package com.sample.Mytest.Resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.Mytest.Services.MyService;
import com.sample.Mytest.Services.PersonService;
import com.sample.Mytest.Services.StudentService;
import com.sample.Mytest.Services.TrackingService;
import com.test.gen.*;
import com.test.gen.Request.TrackingRequest;
import com.test.gen.Response.TrackingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping(value="/sanu")
public class MyResource {

   @Autowired
    MyService myService;

   @Autowired
    TrackingService trackingService;
    @GetMapping(path="/test/v1")
    public MySchema myMethod(){
        System.out.println("Super!!!");
        return myService.implementService();

    }
    @PostMapping(value ="/test/v1")
    public PersonOutput postMethod(@RequestBody Person person) throws JsonProcessingException {
        PersonService personService=new PersonService();
        return personService.personServiceImpl(person);

    }

    @RequestMapping(value="/test/v1/{student}",  method= RequestMethod.GET)
    public Student postVariableMethod(@PathVariable String student){
        StudentService studentService=new StudentService();
        return studentService.studentServiceImp(student);

    }

    @PostMapping(value="/test/v1/tracking")
    public TrackingResponse trackPackage(@RequestBody TrackingRequest trackingRequest){
        return trackingService.trackingServiceImpl(trackingRequest);
    }
}
