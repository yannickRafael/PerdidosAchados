package com.sfs.perdidosachados.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "isCritic")
    private Boolean isCritic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getIsCritic() {
        return isCritic;
    }

    public void setIsCritic(Boolean isCritic) {
        this.isCritic = isCritic;
    }

}