package com.magea.todoapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magea.todoapp.persistence.entity.Task;
import com.magea.todoapp.persistence.entity.TaskStatus;
import com.magea.todoapp.service.TaskService;
import com.magea.todoapp.service.dto.TaskInDTO;

@RestController //Esta anotacion es para que esta clase sea tratada como controlador por Spring.
@RequestMapping("/tasks") //permite definir el camino hasta nuestro controlador ( poner en plural ).

//La capa de controlador solo debe de comunicarse con la capa de servicio, QUE NO HAGA NADA MÁS.
public class TaskController {

	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping  // Le indicamos que desde la aplicacion se hace un post.
	public Task createTask(@RequestBody TaskInDTO taskInDTO) {
		return this.taskService.createTask(taskInDTO);
	}
	
	@GetMapping // Vamos a obtener datos en la aplicacion.
	public List<Task> findAll(){
		return this.taskService.findAll();
	}
	
	@GetMapping ("/status/{status}")
	public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){ // variable de la url llamada status de tipo TaskStatus
		return this.taskService.findAllByTaskStatus(status);
	}
	
	@PatchMapping ("/markAsFinished/{id}") // actualizacion
	public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
		this.taskService.updateTaskFinished(id);
		return ResponseEntity.noContent().build();
		
	}
	@DeleteMapping ("/{id}") // actualizacion
	public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id){
		this.taskService.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
}	
