package example.day03.어노테이션;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Exam1 {
    class SuperClass{void method(){}} // 상위클래스
    class SubClass extends SuperClass{ // 하위클래스
        @Override void method(){} // 상위클래스로부터 물려받은 메소드 재정의 알리는 어노테이션
        @Deprecated void method2(){} // 더이상 사용하지 않는 메소드 알리는 어노테이션
    }

    //어노테이션 만들기 : 인터페이스 기반
    //@Retention(RetentionPolicy)
}
