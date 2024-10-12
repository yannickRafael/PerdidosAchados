package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Item;
import com.sfs.perdidosachados.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
