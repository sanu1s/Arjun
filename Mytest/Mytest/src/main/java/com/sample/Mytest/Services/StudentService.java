package com.sample.Mytest.Services;

import com.test.gen.Course;
import com.test.gen.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class StudentService {

    Executor executor= Executors.newFixedThreadPool(10);
    public Student studentServiceImp (String studentID){
        Student student1=new Student();
        if(Objects.nonNull(studentID)) {
            int id = Integer.parseInt(studentID);
            if(id%2==0) {
               System.out.println("Its an even Number");
                setCourses(student1,"Maths","500");
                return student1;

            }
            else{
                System.out.println("Its an odd Number");
                setCourses(student1,"English","1000");
                return student1;
            }
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("My Name is Arjun"+Thread.currentThread());
            }
        });
        return student1;
    }

    public Student setCourses(Student student1,String name,String fees){
        Course course=new Course();
        course.setName(name);
        course.setFees(fees);

        List<Course> courses=new ArrayList<Course>();
        courses.add(course);
        student1.setCourses(courses);
        return student1;
    }
}
