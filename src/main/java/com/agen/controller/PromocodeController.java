package com.agen.controller;

import com.agen.orderdiscount.entity.Promocode;
import com.agen.orderdiscount.entity.RunningAccount;
import com.agen.orderdiscount.repository.PromocodeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("promocode")
public class PromocodeController {

    @Resource
    private PromocodeRepository promocodeRepository;
    /**
     * 分页查询  优惠券
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping("getPromocode10")
    @ResponseBody
    public Page<Promocode> getPromocode10(int pageNumber, int pageSize){

        Pageable pageable = new PageRequest(pageNumber,pageSize);
        Page<Promocode> promocodePages = promocodeRepository.findAll(new Specification<Promocode>() {
            @Override
            public Predicate toPredicate(Root<Promocode> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("codeDate")));
                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        },pageable);

        return promocodePages;
    }

    @RequestMapping("updatePromoStr")
    @ResponseBody
    public String  updatePromoStr(String codeId,Double promoDiscount){
        if(Objects.nonNull(codeId) && Objects.nonNull(promoDiscount) && promoDiscount >0 && promoDiscount <= 1){
            Promocode promocode = promocodeRepository.findOne(codeId);
            if(Objects.nonNull(promocode)){
                promocode.setPromoDiscount(promoDiscount);
                Promocode promocode1 = promocodeRepository.saveAndFlush(promocode);
                if(Objects.nonNull(promocode1)){
                    return "success";
                }
                return "fail";
            }
        }
        return "error";
    }


}
