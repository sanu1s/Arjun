package com.sample.Mytest.Services;

import com.test.gen.Data;
import com.test.gen.MySchema;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    public MySchema implementService(){
        MySchema mySchema= new MySchema();
        Data data= new Data();
        data.setAge("40");
        data.setEmployeeId("139315");
        data.setSalary("130000");
        data.setName("Arjun");
        mySchema.setData(data);
        return mySchema;
    }
}
