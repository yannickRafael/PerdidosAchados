package com.sfs.perdidosachados.repository;

import com.sfs.perdidosachados.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
