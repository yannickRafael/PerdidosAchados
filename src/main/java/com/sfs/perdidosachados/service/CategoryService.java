package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Category;
import com.sfs.perdidosachados.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateById(int id, Category category) {
        return categoryRepository.updateCategoriesById(id, category);
    }

    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
