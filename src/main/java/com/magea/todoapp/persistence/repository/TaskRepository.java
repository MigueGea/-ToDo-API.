package com.magea.todoapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magea.todoapp.persistence.entity.Task;
import com.magea.todoapp.persistence.entity.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long>{ //Necesita el nombre de la entidad, y el tipo de dato del identificador.
	
	
	public List<Task> findAllByTaskStatus(TaskStatus status);
	
	@Modifying //Es una query de actualizacion
	@Query(value="UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true) //Esta query se ejecutara cuando se lance el metodo de abajo
	public void markTaskAsFinished(@Param("id") Long id); //Le pasamos el id de la tarea

}
