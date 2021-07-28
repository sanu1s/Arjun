package com.sample.Mytest.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.Mytest.mapper.IPersonMapper;
//import com.sample.Mytest.mapper.PersonMapper;
import com.test.gen.Person;
import com.test.gen.PersonOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

//import com.sample.Mytest.mapper.PersonMapper;


@Slf4j
public class PersonService {

    @Autowired
    private IPersonMapper iPersonMapper;
           //=new PersonMapper();

    public PersonOutput personServiceImpl(Person person) throws JsonProcessingException {
        System.out.println("Print"+ new ObjectMapper().writeValueAsString(person));
       /* personOutput.setPhoneNumber(
                person.getPhoneNumbers().stream().findFirst()
                .map(a->a.getNumber()));*/
        PersonOutput personOutput=new PersonOutput();
        personOutput.setPhoneNumber(person.getPhoneNumbers()
                .stream().map(a->a.getNumber()).findFirst().orElse("0"));

         return formatOutput(iPersonMapper.output(person));

}

public PersonOutput formatOutput(PersonOutput personOutput){


        return personOutput;
}
}
