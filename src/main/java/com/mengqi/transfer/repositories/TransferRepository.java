package com.mengqi.transfer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mengqi.transfer.models.Transfer;

/**
 * A repository interface for the transfers.
 *
 * @author Mengqi Yang
 */
@Repository("TransferRepository")
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
