package com.mengqi.transfer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mengqi.transfer.models.Account;

/**
 * A repository interface for the accounts.
 *
 * @author Mengqi Yang
 */
@Repository("AccountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
}
