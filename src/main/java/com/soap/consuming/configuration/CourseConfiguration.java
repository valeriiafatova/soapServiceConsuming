package com.soap.consuming.configuration;

import com.soap.consuming.client.CourseClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CourseConfiguration {
    
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.consuming.wsdl");
        return marshaller;
    }
    
    @Bean
    public CourseClient courseClient(Jaxb2Marshaller marshaller){
        CourseClient client = new CourseClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
