package com.soap.consuming;

import com.soap.consuming.client.CourseClient;
import com.soap.consuming.wsdl.Course;
import com.soap.consuming.wsdl.GetCourseResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(CourseClient courseClient) {
        return args -> {
            String title = "REST";

            if (args.length > 0) {
                title = args[0];
            }
            GetCourseResponse response = courseClient.getCourse(title);
            Course course = response.getCourse();
            System.err.println("Course id: " + course.getId() + ", title: " + course.getTitle());
        };
    }
}
