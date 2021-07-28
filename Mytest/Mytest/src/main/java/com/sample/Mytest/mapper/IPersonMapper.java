package com.sample.Mytest.mapper;

import com.test.gen.Person;
import com.test.gen.PersonOutput;
import org.mapstruct.*;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.ReportingPolicy.IGNORE;




@Mapper(implementationName = "PersonMapper",
        unmappedTargetPolicy = IGNORE,
        nullValueMappingStrategy = RETURN_DEFAULT)
public interface IPersonMapper {
  // IPersonMapper INSTANCE= Mappers.getMapper(IPersonMapper.class);
    /**
     * @param person
     * @return
     */

   @Mappings
  ({@Mapping(source = "firstName",target = "myname"),
    @Mapping(source = "age",target = "myAge"),
    @Mapping(source="address.streetAddress" ,target="phoneNumber")
  })
    PersonOutput output(Person person);

  @AfterMapping
   default void afterMapping(Person person,@MappingTarget  PersonOutput personOutput){
       personOutput.setPhoneNumber(
               person.getPhoneNumbers().stream().map(a->a.getNumber()).findFirst().get()
       );
    System.out.println("My Phone Number"+person.getPhoneNumbers().stream().map(a->a.getNumber()).findFirst().get());
    }
}
