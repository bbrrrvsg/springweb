package example.prcatice.practice7.controller;

import example.prcatice.practice7.dto.cDto;
import example.prcatice.practice7.dto.eDto;
import example.prcatice.practice7.dto.sDto;
import example.prcatice.practice7.service.Aservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {

    @Autowired
    private Aservice aservice;
    @PostMapping("/course")
    public boolean add1(cDto cdto){
        boolean result = aservice.add1(cdto);
        return result;
    }
    @PostMapping("/enroll")
    public boolean add2(eDto edto){
        boolean result = aservice.add2(edto);
        return result;
    }
    @PostMapping("/student")
    public boolean add3(sDto sdto){
        boolean result = aservice.add3(sdto);
        return result;
    }
}
