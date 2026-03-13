package example.prcatice.practice7.controller;

import example.prcatice.practice7.service.aService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class aControl {

    @Autowired private aService aservice;

    // 과정 등록
    @PostMapping("/add1") // map타입이란? key value 한쌍(entry)으로 여러 엔트리를 저장 == JSON/DTO
    public boolean add1(@RequestBody Map<String,Object>map){
        boolean result = aservice.add1(map); return result;
    }

    // 학생 등록
    @PostMapping("/add2")
    public boolean add2(@RequestBody Map<String,Object>map){
        boolean result = aservice.add2(map);
        return result;
    }

    // 수강 신청 등록
    @PostMapping("/add3")
    public boolean add3(@RequestBody Map<String,Object>map){
        boolean result = aservice.add3(map);
        return result;
    }

    @GetMapping("/get")
    public Map<String,Object>get(@RequestParam int eid){
        return aservice.get(eid);
    }
}
