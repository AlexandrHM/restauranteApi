package com.website.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.website.restaurant.entity.PlatilloEntity;

public interface PlatilloRepository extends JpaRepository<PlatilloEntity, Long> {
}