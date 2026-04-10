package manager2.department.controller;

import com.manager2.department.dto.deDTO;
import com.manager2.department.service.deService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/depart")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class deController {

    private final deService deservice;

    // c
    @PostMapping("/add")
    public ResponseEntity<?> deAdd(@RequestBody deDTO dedto){
        return ResponseEntity.ok(deservice.add(dedto));
    }

    // r
    @GetMapping("/print1")
    public ResponseEntity<?> pring1(){
        return ResponseEntity.ok(deservice.print1());
    }

    // u
    @PutMapping("/update1")
    public ResponseEntity<?> update1(@RequestParam Long did, @RequestBody deDTO deDTO){
        return ResponseEntity.ok(deservice.update1(did, deDTO));
    }

    // d
    @DeleteMapping("/delete1")
    public ResponseEntity<?> delete1(@RequestParam Long did){
        return ResponseEntity.ok(deservice.delete1(did));
    }
}
