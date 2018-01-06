package com.mengqi.transfer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mengqi.transfer.models.Account;

@Repository("AccountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
}
