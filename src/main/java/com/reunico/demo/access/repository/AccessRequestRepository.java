package com.reunico.demo.access.repository;

import com.reunico.demo.access.domain.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    Optional<AccessRequest> findOneByEntityId(Long entityId);

}
