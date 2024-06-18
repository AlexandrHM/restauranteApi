package com.website.restaurant.service;

import java.util.List;
//import java.util.NoSuchElementException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.restaurant.repository.PlatilloRepository;
import com.website.restaurant.entity.PlatilloEntity;

@Service
public class PlatilloService {
    
    private final PlatilloRepository platilloRepository;

	//@Autowired
	public PlatilloService(PlatilloRepository platilloRepository) {
		this.platilloRepository = platilloRepository;
	}

	public PlatilloEntity savePlatillo(PlatilloEntity platilloEntity) {
		return platilloRepository.save(platilloEntity);
	}

	public List<PlatilloEntity> getAllPlatillos() {
		return platilloRepository.findAll();
	}

	public PlatilloEntity findPlatilloById(Long id) {
		return platilloRepository.findById(id).orElse(null);
	}

	public void deletePlatillo(Long id) {
		platilloRepository.deleteById(id);
	}

    
}
