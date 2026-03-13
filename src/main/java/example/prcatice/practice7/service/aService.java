package example.prcatice.practice7.service;

import example.prcatice.practice7.Entity.CourseEntity;
import example.prcatice.practice7.Entity.EnrollEntity;
import example.prcatice.practice7.Entity.StudentEntity;
import example.prcatice.practice7.repository.CourseRepository;
import example.prcatice.practice7.repository.EnrollRepository;
import example.prcatice.practice7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class aService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollRepository enrollRepository;
    @Autowired
    private StudentRepository studentRepository;


    //과정 등록
    public boolean add1(Map<String,Object>map){
        CourseEntity saveEntity = new CourseEntity();
        saveEntity.setCname(String.valueOf(map.get("cname")));
        CourseEntity saved = courseRepository.save(saveEntity);
        if (saved.getCid()>=1)return true;
        return false;
    }

    // 학생 등록
    public boolean add2(Map<String,Object>map){
        StudentEntity saveEntity = new StudentEntity();
        saveEntity.setSname(map.get("sname").toString());
        StudentEntity saved = studentRepository.save(saveEntity);
        if (saved.getSid()>=1)return true;
        return false;
    }

    // 수강 신청 등록
    public boolean add3(Map<String,Object>map){
        EnrollEntity saveE = new EnrollEntity();
        saveE.setEname(String.valueOf(map.get("ename")));

        // fk 에 해당하는 엔티티 개입
        int cid = Integer.parseInt(map.get("cid").toString());
        Optional<CourseEntity> optionalEntity = courseRepository.findById(cid);
        if (optionalEntity.isPresent()){
            CourseEntity courseEntity = optionalEntity.get();
            saveE.setCourseEntity(courseEntity);
        }else {return false;}

        int sid = Integer.parseInt(map.get("sid").toString()); // sid 확인
        Optional<StudentEntity>optionalStudentEntity = studentRepository.findById(sid); // sid에 해당하는 엔티티 1개 조회
        if (optionalStudentEntity.isPresent()){ // 존재한다면
            StudentEntity studentEntity = optionalStudentEntity.get(); // 학생엔티티꺼내서
            saveE.setStudentEntity(studentEntity); // 학생엔티티를 수강신청 엔티티에 대입
        }else {return false;}

        EnrollEntity saved = enrollRepository.save(saveE);

        if (saved.getEid()>=1)return true;
        return false;
    }

    // ㅈ회
    public Map<String,Object>get(int eid){
        // eid에 해당하는 엔티티 찾기
        Optional<EnrollEntity>optionalEnrollEntity = enrollRepository.findById(eid);
        if (optionalEnrollEntity.isPresent()){
            EnrollEntity enrollEntity = optionalEnrollEntity.get();
            Map<String,Object>map = new HashMap<>();
            map.put("eid",enrollEntity.getEid());
            map.put("ename",enrollEntity.getEname());
            map.put("createdate",enrollEntity.getCreatedate());
            map.put("updatedate",enrollEntity.getUpdatedate());
            map.put("cname",enrollEntity.getCourseEntity().getCname());
            map.put("sname",enrollEntity.getStudentEntity().getSname());
            return map;

        }
        return null;
    }









}
