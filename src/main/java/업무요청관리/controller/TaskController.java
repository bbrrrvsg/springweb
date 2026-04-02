package 업무요청관리.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import 업무요청관리.dto.TaskDto;
import 업무요청관리.service.TaskService;

@RequiredArgsConstructor
@RestController@RequestMapping("/api/task") // 리액트 경로 =/task vs 스프링 경로 중복될 수 있으므로 api/task
@CrossOrigin(origins = "http://localhost:5173") // 서로 다른 port(프로그램 식별번호) 간의 통신 허용
// SOP 정책으로 도메인은 통신이 불가능하다. HTTP 보안 정책
// CORS : 교차 출처 리소스 공유 , 즉[ 서로 다른 도메인(8080:스프링 , 5173:리액트) 통신 공유 허용
public class TaskController {

    private final TaskService taskService;



    @PostMapping
    public ResponseEntity<?> taskPost(@RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.taskPost(taskDto));
    }

    @GetMapping
    public ResponseEntity<?> taskList(){
        return ResponseEntity.ok(taskService.taskList());
    }

    // [3] 업무 요청 상세 조회
    @GetMapping("/detail")
    public ResponseEntity<?> getTaskDetail(@RequestParam Integer id) {
        return ResponseEntity.ok(taskService.getTaskDetail(id));
    }

    // [4] 업무 요청 수정
    @PutMapping
    public ResponseEntity<?> updateTask(@RequestParam Integer id, @RequestBody TaskDto request) {
        return ResponseEntity .ok(taskService.updateTask(id, request));
    }

    // [5] 업무 요청 삭제
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
