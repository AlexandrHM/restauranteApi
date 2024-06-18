package com.website.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.website.restaurant.entity.PlatilloEntity;
import com.website.restaurant.service.PlatilloService;

@RestController // <-- GET,PUT,DELETE,POST
@RequestMapping("/api/v1/restaurante") //<-- GetMapping(url)
public class PlatilloController {
    
    // Declaración de la instancia de Logger
    private static final Logger logger = LoggerFactory.getLogger(PlatilloController.class);
    
    @Autowired
    private PlatilloService platilloService;
    
    /*Metodos*/
    //CrearPlatillo
    @PostMapping
    public ResponseEntity<PlatilloEntity> crearPlatillo(@RequestBody PlatilloEntity platilloEntity) {
		logger.info("Recibida solicitud POST para crear un nuevo estudiante: {}", platilloEntity);
		PlatilloEntity platilloGuardado = platilloService.savePlatillo(platilloEntity);
		return new ResponseEntity<>(platilloGuardado, HttpStatus.CREATED);
	}

    // Obtiene todos los platillos
	@GetMapping
	public ResponseEntity<List<PlatilloEntity>> obtenerTodosLosPlatillos() {
		logger.info("Recibida solicitud GET para obtener todos los platillos");
		List<PlatilloEntity> platillos = platilloService.getAllPlatillos();
		logger.info("Se encontraron {} platillos", platillos.size());
		return new ResponseEntity<>(platillos, HttpStatus.OK);
	}

    // Obtiene estudiante por id
	@GetMapping("/{id}")
	public ResponseEntity<PlatilloEntity> obtenerEstudiantePorId(@PathVariable Long id) {
		logger.info("Recibida solicitud GET para obtener el estudiante con ID: {}", id);
		PlatilloEntity estudianteEntity = platilloService.findPlatilloById(id);
		return estudianteEntity != null ? new ResponseEntity<>(estudianteEntity, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    //Actualizar un dato
    @PatchMapping(value = "/{id}")
	public ResponseEntity<Object> update(@RequestBody PlatilloEntity platilloEntity, @PathVariable Long id) {
		try {
			PlatilloEntity currentPlatilloEntity = platilloService.findPlatilloById(id);
			currentPlatilloEntity.setNombre(platilloEntity.getNombre());
			currentPlatilloEntity.setDescripcion(platilloEntity.getDescripcion());
            currentPlatilloEntity.setPrecio(platilloEntity.getPrecio());
			currentPlatilloEntity.setCategoria(platilloEntity.getCategoria());

			PlatilloEntity updatedPlatillo = platilloService.savePlatillo(currentPlatilloEntity);
			return ResponseEntity.ok(updatedPlatillo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al actualizar estudiante: " + e.getMessage());
		}
	}

    // Elimina un estudiante por id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPlatillo(@PathVariable Long id) {
		platilloService.deletePlatillo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
