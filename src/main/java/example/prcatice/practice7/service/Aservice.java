package example.prcatice.practice7.service;

import example.prcatice.practice7.Entity.CourseEntity;
import example.prcatice.practice7.dto.cDto;
import example.prcatice.practice7.dto.eDto;
import example.prcatice.practice7.dto.sDto;
import example.prcatice.practice7.repository.CourseRepository;
import example.prcatice.practice7.repository.EnrollRepository;
import example.prcatice.practice7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Aservice {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollRepository enrollRepository;
    @Autowired
    private StudentRepository studentRepository;

    public boolean add1(cDto cdto){
        CourseEntity courseEntity = CourseEntity
                .builder()

                .build();
    }
    public boolean add2(eDto edto){

    }
    public boolean add3(sDto sdto){

    }







}
