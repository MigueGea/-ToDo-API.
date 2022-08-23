package com.magea.todoapp.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //para los setter y getter de lombok
@Entity //Indicar que es una entidad
@Table(name = "task") //Indicar el nombre de la tabla
public class Task {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO) //Estrategia que va a usar Spring junto a JPA e Hibernate en dependencia de la BBDD que usemos 
	private Long id; //campo que será el id para la bbdd.
	private String tittle;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime eta; //eta-> fecha de finalizacion estimada.
	private boolean finished;
	private TaskStatus taskStatus;
}
