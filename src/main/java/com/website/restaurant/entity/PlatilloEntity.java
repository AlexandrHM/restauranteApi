package com.website.restaurant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*Mapeo de la tabla*/
@Entity
//crear la tabla a la BD
@Table(name = "Platillos")//<== tabla de bd
@Data //genera los getters y setters
public class PlatilloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPlatillo")
    private Long id;

    @Column(name="nombre", length = 100, nullable = false)
	 private String nombre;
	
	@Column(name="descripcion")
	 private String descripcion;
	
	@Column(name="precio")
	 private Integer precio;
    
    @Column(name="categoria")
	private String categoria;
}
