package com.example.democustomid.controller;


import com.example.democustomid.entity.MyEntity;
import com.example.democustomid.service.MyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class MyEntityController {

    @Autowired
    private MyEntityService service;

    // GET endpoint to fetch entity by customId
    @GetMapping("/{customId}")
    public MyEntity getByCustomId(@PathVariable String customId) {
        return service.getByCustomId(customId);
    }

    // POST endpoint to create a new entity
    @PostMapping
    public MyEntity createEntity(@RequestBody MyEntity entity) {
        return service.createEntity(entity);
    }

    // PUT endpoint to update an existing entity
    @PutMapping("/{id}")
    public MyEntity updateEntity(@PathVariable Long id, @RequestBody MyEntity updatedEntity) {
        return service.updateEntity(id, updatedEntity);
    }

    // DELETE endpoint to delete an entity by id
    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        service.deleteEntity(id);
    }

    // GET endpoint to fetch all entities
    @GetMapping
    public List<MyEntity> getAllEntities() {
        return service.getAllEntities();
    }
}
