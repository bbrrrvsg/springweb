package example.day10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exam3 {
    public static void main(String[] args) {

        // 람다표현식 , ()->{}

        // 스트림API : 데이터(매개변수) --> 중간연산 --> 최종출력

        List<Integer>number = List.of(1,2,3,4,5,6,7,8,9,10); // 임의의 데이터를 담고있는 리스트

        //[1] 리스트변수명.stream().forEach(); , 중간연산 없이 바로 최종출력
        // 매개변수에 반복변수를 하나씩 대입하여 return 없는 반복문
        number.stream().forEach((x)->{
            System.out.println(x*2);
        });

        //[2] 리스트변수명.map(중간연산).collect(최종출력)
        // 매개변수에 반복변수를 하나씩 대입하여 return 있는 반복문 , 반복 return 값들을 .collect(Collectors.toXXX()); 반환 받는다
        List<Integer>result =
            number.stream()
                    .map(x->x*2) // 중간연산
                    .collect(Collectors.toList()); // 중간연산 결과를 새로운 리스트에 반환 해준다
        System.out.println("result = " + result);

        //[3] 리스트변수명.stream().map(중간연산).forEach(최종출력);
        number.stream()
                .map(x-> x*2) // 중간연산
                .forEach(result1-> System.out.println("result = " + result)); // 중간연산 결과를 출력한다.


        //[4] 리스트변수명.stream().filter().forEach()
        number.stream()
                .filter(x->x%2==0) // 중간연산 , 짝수만 반환
                .forEach(y-> System.out.println("y = " + y)); // 최종출력

        //[5] 리스트변수명.stream().sorted().forEach()
        number.stream() // 리스트내 데이터들의 흐름 시작
                .sorted(Comparator.reverseOrder()) // 중간연산 , 오름차순 , 내림차순(Comparator.reverseOrder())
                .forEach(y-> System.out.println("y = " + y));

        //[6]
        number.stream()
                .distinct() // 중복제거 중간연산
                .collect(Collectors.toList());

        //[7]
        number.stream()
                .limit(5) // 앞에서 부터 N개 까지
                .forEach(y-> System.out.println("z = " + y));

        /*
            스트림이란? 데이터 다니는 연속적인 흐름
                - 데이터 들 ----> 중간연산 ----> 최종연산
                - 중간연산은 여러개 가능
                - 최종연산은 반드시 1개 가능n

            주요연산
                - 중간연산 : .map() .filter() .sorted() .distinct() .limit()
                - 최종연산 : forEach() collect()


         */
    }


}
