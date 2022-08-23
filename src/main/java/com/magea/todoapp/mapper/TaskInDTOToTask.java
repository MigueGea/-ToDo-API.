package com.magea.todoapp.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.magea.todoapp.persistence.entity.Task;
import com.magea.todoapp.persistence.entity.TaskStatus;
import com.magea.todoapp.service.dto.TaskInDTO;

@Component // Se declara como componente de Spring para poder inyectarlo facilmente con Spring
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

	//Este metodo nos convierte un TaskInDTO ( Task con menos atributos ) en un Task ( Entidad con todos los atrib.)
	@Override
	public Task map(TaskInDTO in) {
		
		Task task = new Task();
		task.setTittle(in.getTittle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedDate(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		return task;
	}
}

