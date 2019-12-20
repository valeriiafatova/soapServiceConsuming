package com.soap.consuming.client;

import com.soap.consuming.wsdl.GetCourseRequest;
import com.soap.consuming.wsdl.GetCourseResponse;
import com.soap.consuming.wsdl.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CourseClient extends WebServiceGatewaySupport {
    
    public GetCourseResponse getCourse(String title){
        GetCourseRequest request = new ObjectFactory().createGetCourseRequest();
        
        request.setTitle(title);

        GetCourseResponse response = (GetCourseResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/", request);
        
        return response;
    }
}
