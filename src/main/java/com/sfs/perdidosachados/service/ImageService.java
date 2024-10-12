package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Image;
import com.sfs.perdidosachados.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public Optional<Image> findById(int id) {
        return imageRepository.findById(id);
    }

    public Image save(Image image) {
        return imageRepository.save(image);
    }

    public Image updateById(int id, Image image) {
        return imageRepository.updateById(id, image);
    }

    public void deleteById(int id) {
        imageRepository.deleteById(id);
    }

}
