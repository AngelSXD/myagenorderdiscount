package com.agen.orderdiscount.repository;


import com.agen.orderdiscount.entity.RunningAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RunningAccount 流水账单持久化层
 *
 * @author SXD
 * @date 2018/1/15
 */
public interface RunningAccountRepository extends JpaRepository<RunningAccount,String> {

}
