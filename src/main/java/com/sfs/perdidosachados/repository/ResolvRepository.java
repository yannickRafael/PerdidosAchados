package com.sfs.perdidosachados.repository;

import com.sfs.perdidosachados.model.Resolv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResolvRepository extends JpaRepository<Resolv, Integer> {

    Resolv updateById(int id, Resolv resolv);

}
