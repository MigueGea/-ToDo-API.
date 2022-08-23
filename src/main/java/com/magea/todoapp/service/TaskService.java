package com.magea.todoapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.magea.todoapp.exceptions.ToDoExceptions;
import com.magea.todoapp.mapper.TaskInDTOToTask;
import com.magea.todoapp.persistence.entity.Task;
import com.magea.todoapp.persistence.entity.TaskStatus;
import com.magea.todoapp.persistence.repository.TaskRepository;
import com.magea.todoapp.service.dto.TaskInDTO;

@Service //Crea un bean en el contenedor de beans de springs, para que sea inyectado donde sea necesario.
public class TaskService {
//Este servicio se conectara al repositorio a traves del controlador, y este a la BBDD.
//Esta clase se va a usar para hacer toda la logica de negocio.
	
	private final TaskRepository repository;
	private final TaskInDTOToTask mapper;
	//Inyeccion de dependencias basada en constructores en vez de la anotacion AutoWire o metodos, porque es mejor practica,
	//ya que facilita la testeabilidad en el futuro.
	public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	//crear una nueva tarea (task)
	public Task createTask(TaskInDTO taskInDTO) {
		Task task = mapper.map(taskInDTO);
		return this.repository.save(task);
	}
	
	public List<Task> findAll(){
		return this.repository.findAll();
	}
	
	public List<Task> findAllByTaskStatus(TaskStatus status){
		
		return this.repository.findAllByTaskStatus(status);
		
	}
	
	@Transactional
	public void updateTaskFinished(Long id) {
		Optional<Task> optionalTask= this.repository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.markTaskAsFinished(id);
	}
	
	public void deleteById(Long id) {
		Optional<Task> optionalTask= this.repository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.deleteById(id);;
	}
}
