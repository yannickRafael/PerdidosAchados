package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Item;
import com.sfs.perdidosachados.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
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

    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    public Optional<Item> update(int id, Item item) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item itemToUpdate = itemOptional.get();
            BeanUtils.copyProperties(item, itemToUpdate, "id");
            itemRepository.save(itemToUpdate);
            return Optional.of(itemToUpdate);
        }
        return Optional.empty();
    }
}
