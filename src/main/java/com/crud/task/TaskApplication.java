package com.crud.task;
import com.crud.tasks.domain.TaskDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {

TaskDto taskDto = new TaskDto(
		(long)1,
		"Test title",
		"I want to be a coder!");
		Long id = taskDto.getId();
		String title = taskDto.getTitle();
		String content = taskDto.getContent();

		System.out.println(id + " " + title + " " + content);
		SpringApplication.run(TaskApplication.class, args);
	}

}
