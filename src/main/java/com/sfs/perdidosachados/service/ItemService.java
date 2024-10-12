package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Item;
import com.sfs.perdidosachados.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(int id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item updateById(int id, Item item) {
        return itemRepository.updateById(id, item);
    }

    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }
}
