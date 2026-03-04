package example.day05.mvc;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    //조회
    public List<ExamDto>전체조회(){
        // findAll : 전체조회
        List<ExamEntity>examEntityList = examRepository.findAll();
        // entity -> DTO 연결 <Entity 노출 안하기 >
        List<ExamDto>examDtoList = new ArrayList<>();
        examEntityList.forEach(entity ->{
            ExamDto examDto = new ExamDto();
            examDto.setEno(entity.getEno());
            examDto.setEname(entity.getEname());
            examDtoList.add(examDto);
        });
        return examDtoList;
    }

    //쓰기
    public boolean 저장(ExamDto examDto){
        //insert 대신에 JPA 함수 사용
        // .save(엔티티)
        //1] 저장할 DTO --> entity 변환
        ExamEntity examEntity = new ExamEntity();
        examEntity.setEname(examDto.getEname());
        // 2] .save 이용한 insert 하고 처리한 entity 반환 ,pk여부확인
        ExamEntity savedEntity = examRepository.save(examEntity);
        //3] 처리한 entity의 pk 여부
        if(savedEntity.getEno()>=1)return true;
        return false;

    }

    //삭제
    public boolean 삭제(int eno){
        // delete 대신에 JPA 함수사용
        // .deleteById(삭제할pk번호)
        examRepository.deleteById(eno);

        return true;
    }

    //수정

    public boolean 수정( ExamDto examDto){
        // update 대신에 JPA 영속성(계속되는 성질/능력) 사용
        // 데이터베이스 와 자바 객체 연결되는 상태 계속적으로 유지
        // 즉] 자바객체가 수정되면 데이터베이스도 자동 수정
        //1] 수정할 엔티티 찾기 , pk
        Optional<ExamEntity>optional =
                examRepository.findById(examDto.getEno());
        //2] 만약에 엔티티가 존재하면 , ispresent() : 조회결과가 있으면 true , 없으면 false 반환 함수
        if(optional.isPresent()){
            ExamEntity examEntity = optional.get(); // 존재한 엔티티 꺼내기
            examEntity.setEname(examDto.getEname()); // 입력받은(수정할) 값을 언티티에 setter 이용하여 수정한다.
            return true;
        }
        return false;
    }

}

/*
    1] <> 제네릭타입 : , 객체 생성할때 타입 지정
    2] Optional<> : 객체내 null 값 제어기능/함수 제공하는 클래스 , null 에따른 안전한 객체 사용
        1. .ispresent() : 만약에 null이면 false반환 , 아니면 true
        2. .get() : 객체 반환
        3. .orElse(null일떄값)
        3. .orElseThrow(예외값)
    사용처 : JPA에서 findById() 반환 타입 그외 몇몇 라이브러리 사용
    사용법 :
        1] Optional<엔티티> 변수명 = repository.findById()
        2] 엔티티 변수명 = repository.findById().orElse()

    3] JPA CRUD 기본제공
        1. .findAll() : 모든 레코드/객체/엔티티 조회 , 반환타입 : List<엔티티명>
        2. .findById(조회할 pk번호) : 특정 pk번호의 엔티티 반환 , 반환타입 : Optional<엔티티명>
        3. .save(저장할 엔티티) : 특정 엔티티를 저장(insert) , 반환타입 : 엔티티
        4. .deleteById(삭제할 pk번호) : 특정pk번호의 엔티티 삭제(delete) , 반환타입 : void
        5. 수정함수는 존재하지 않는다. <영속성 특징>
            - 영속성 갖는 시점 : save, findAll, findById 등등 반환된 엔티티가 영속된 엔티티
            * 영속성이란? 데이터베이스 와 자바 객체 연결하는 관계
            - 영속된 엔티티를 .setter 이용하여 객체 수정하면 자동으로 데이터베이스도 반영된다.
            - @Transactional 갖는 클래스/메소드 는 여러 sql들을 하나의 묶음으로 한번에 처리한다.
                -즉] 트랜잭션이란? 여러 sql들을 묶어서 하나라도 실패하면 모두 실패(rollback) 모두 성공이면 최종성공(commit)
                - 영속된 객체를 .setter 이용하여 여러개 수정함으로써 여러개 수정들을 하나로 처리한다.
                - 즉] 수정하는 메소드에는 @Transactional 필수이다.
        6.



 */