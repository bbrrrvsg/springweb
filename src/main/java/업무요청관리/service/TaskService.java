package 업무요청관리.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 업무요청관리.dto.TaskDto;
import 업무요청관리.entity.TaskEntity;
import 업무요청관리.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;



    // [1] 등록
    public TaskDto taskPost(TaskDto taskDto){
        return taskRepository.save(taskDto.toEntity()).toDto();
    }

    // [2] 전체조회
    public List<TaskDto> taskList(){
        return taskRepository.findAll().stream().map(TaskEntity::toDto).collect(Collectors.toList());
    }

    // [3] 업무 요청 상세 조회
    public TaskDto getTaskDetail( Integer id){
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        return taskEntity.toDto();
    }

    // [4] 업무 요청 수정
    @Transactional
    public TaskDto updateTask( Integer id, TaskDto request){
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        taskEntity.setTitle(request.getTitle());
        taskEntity.setContent(request.getContent());
        taskEntity.setStatus(request.getStatus());
        return taskEntity.toDto();
    }

    // [5] 업무 요청 삭제
    public void deleteTask( Integer id){
        TaskEntity task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
    }

}
