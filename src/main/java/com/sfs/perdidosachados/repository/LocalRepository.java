package com.sfs.perdidosachados.repository;

import com.sfs.perdidosachados.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {

}
