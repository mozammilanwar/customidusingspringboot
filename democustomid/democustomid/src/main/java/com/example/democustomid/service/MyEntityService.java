package com.example.democustomid.service;


import com.example.democustomid.entity.MyEntity;
import com.example.democustomid.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEntityService {

    @Autowired
    private MyEntityRepository repository;

    // Method to create an entity
    public MyEntity createEntity(MyEntity entity) {
        return repository.save(entity);
    }

    // Method to fetch entity by customId
    public MyEntity getByCustomId(String customId) {
        return repository.findByCustomId(customId);
    }

    // Method to update an entity
    public MyEntity updateEntity(Long id, MyEntity updatedEntity) {
        MyEntity existingEntity = repository.findById(id).orElse(null);
        if (existingEntity != null) {
            existingEntity.setName(updatedEntity.getName());
            // Add more fields to update as needed
            return repository.save(existingEntity);
        }
        return null; // Or throw an exception if entity not found
    }

    // Method to delete an entity
    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    // Method to fetch all entities
    public List<MyEntity> getAllEntities() {
        return repository.findAll();
    }
}
