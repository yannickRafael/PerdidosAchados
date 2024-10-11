package com.sfs.perdidosachados.repository;

import com.sfs.perdidosachados.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Category, Integer> {

}
