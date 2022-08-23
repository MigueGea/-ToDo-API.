package com.magea.todoapp.service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskInDTO {
	//Esta clase DTO es creada porque cuando creamos una nueva tarea, no vamos a querer TODOS los datos de la entidad, por lo que
	// aquí decidimos con cuales nos quedamos y con cuales no.
	
	private String tittle;
	private String description;
	private LocalDateTime eta; 
}
