package com.agen.orderdiscount.repository;

import com.agen.orderdiscount.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,String> {

    Wallet findWalletByAdminId(Integer adminId);
}
