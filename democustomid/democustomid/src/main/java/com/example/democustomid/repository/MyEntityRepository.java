package com.example.democustomid.repository;

import com.example.democustomid.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {

    MyEntity findByCustomId(String customId);
}

