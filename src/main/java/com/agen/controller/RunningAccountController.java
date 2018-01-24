package com.agen.controller;

import com.agen.orderdiscount.entity.AvAmount;
import com.agen.orderdiscount.entity.EsAmount;
import com.agen.orderdiscount.entity.RunningAccount;
import com.agen.orderdiscount.repository.AvAmountRepository;
import com.agen.orderdiscount.repository.EsAmountRepository;
import com.agen.orderdiscount.repository.RunningAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 流水Controller
 *
 * @author SXD
 * @date 2018/1/18
 */
@Controller
@RequestMapping("runAc")
public class RunningAccountController {

    @Resource
    private EsAmountRepository esAmountRepository;
    @Resource
    private AvAmountRepository avAmountRepository;
    @Resource
    private RunningAccountRepository runningAccountRepository;

    /**
     * 跳转  历时订单 和 流水账单
     * @param currentValue
     * @param model
     * @return
     */
    @RequestMapping("checkDiscount")
    public String checkEs(String currentValue, Model model){
        model.addAttribute("currentValue",currentValue);
        return "index/running";
    }

    /**
     * 分页查询  预估订单历史变化
     * @param pageNumber
     * @param pageSize
     * @param adminId
     * @return
     */
    @RequestMapping("getEsAmount10")
    @ResponseBody
    public Page<EsAmount> getEsAmount10(int pageNumber,int pageSize,Integer adminId){
        if(Objects.nonNull(adminId)){
            Pageable pageable = new PageRequest(pageNumber,pageSize);
            Page<EsAmount> esAmountPages = esAmountRepository.findAll(new Specification<EsAmount>() {
                @Override
                public Predicate toPredicate(Root<EsAmount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> list = new ArrayList<>();

                        list.add(criteriaBuilder.equal(root.get("adminId").as(Integer.class),adminId));
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("esDate")));

                    Predicate[] predicates = new Predicate[list.size()];
                    predicates = list.toArray(predicates);
                    return criteriaBuilder.and(predicates);
                }
            },pageable) ;

            return esAmountPages;
        }else{
            return null;
        }
    }

    /**
     * 分页查询  可提现订单变化
     * @param pageNumber
     * @param pageSize
     * @param adminId
     * @return
     */
    @RequestMapping("getAvAmount10")
    @ResponseBody
    public Page<AvAmount> getAvAmount10(int pageNumber, int pageSize, Integer adminId){

        Pageable pageable = new PageRequest(pageNumber,pageSize);
        Page<AvAmount> avAmountPages = avAmountRepository.findAll(new Specification<AvAmount>() {
            @Override
            public Predicate toPredicate(Root<AvAmount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(Objects.nonNull(adminId)){
                    list.add(criteriaBuilder.equal(root.get("adminId").as(Integer.class),adminId));
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get("avDate")));
                }
                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        },pageable) ;

        return avAmountPages;
    }

    /**
     * 分页查询  流水账单
     * @param pageNumber
     * @param pageSize
     * @param adminId
     * @return
     */
    @RequestMapping("getRunningAccount10")
    @ResponseBody
    public Page<RunningAccount> getRunningAccount10(int pageNumber, int pageSize, Integer adminId){

        Pageable pageable = new PageRequest(pageNumber,pageSize);
        Page<RunningAccount> runningAccountPages = runningAccountRepository.findAll(new Specification<RunningAccount>() {
            @Override
            public Predicate toPredicate(Root<RunningAccount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(Objects.nonNull(adminId)){
                    list.add(criteriaBuilder.equal(root.get("adminId").as(Integer.class),adminId));
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get("raDate")));
                }
                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        },pageable) ;

        return runningAccountPages;
    }


    /**
     *
     * @param asAccountIds
     * @return  <orderSn,"success"/"error">
     */
    @RequestMapping("withdraw")
    @ResponseBody
    @Transactional
    public Map<String,String> withdraw(String[] asAccountIds){
        List<AvAmount> avAmountList = avAmountRepository.findAll(new Specification<AvAmount>() {
            @Override
            public Predicate toPredicate(Root<AvAmount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(Objects.nonNull(asAccountIds) && asAccountIds.length > 0){
                    list.add(root.get("avId").in(asAccountIds));
                    Predicate[] predicates = new Predicate[list.size()];
                    predicates = list.toArray(predicates);
                    return criteriaBuilder.and(predicates);
                }else{
                    return null;
                }

            }
        });

        Map<String,String> map = new HashMap<>();

        if(Objects.nonNull(avAmountList) && avAmountList.size() > 0){
            Double raAccount = 0D;
            for (AvAmount avAmount : avAmountList) {
                avAmount.setAmountStatus(2);
                raAccount+=avAmount.getAvAccount();
                map.put(avAmount.getOrderSn(),"success");
            }

            String uuid = UUID.randomUUID().toString();
            RunningAccount runningAccount = new RunningAccount();
            runningAccount.setRaId(uuid);
            runningAccount.setAccountStatus(1);
            runningAccount.setAdminId(avAmountList.get(0).getAdminId());
            runningAccount.setRaAccount(raAccount);
            runningAccount.setRaDate(new Date());
            runningAccount.setRaOperater(avAmountList.get(0).getAvOperater());
            runningAccount.setRaSn(System.currentTimeMillis()+uuid);
            runningAccount.setChildAvamounts(avAmountList);

            RunningAccount runningAccount1 = runningAccountRepository.save(runningAccount);
            if(Objects.nonNull(runningAccount)){
                for (AvAmount avAmount : avAmountList) {
                    avAmount.setParentRa(runningAccount1);
                }
                return map;
            }
        }

        return  null;
    }




}
