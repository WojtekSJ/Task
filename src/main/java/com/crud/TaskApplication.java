package com.crud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
	public class TaskApplication extends SpringBootServletInitializer {

		public static void main(String[] args) {

			SpringApplication.run(TaskApplication.class, args);
		}
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(TaskApplication.class);
		}

	}


//Heroku
/*
@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {

        SpringApplication.run(TaskApplication.class, args);
    }
    */
/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TaskApplication.class);
    }*//*

}*/
