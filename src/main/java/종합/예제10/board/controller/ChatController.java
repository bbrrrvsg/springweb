package 종합.예제10.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.board.dto.ChatDto;
import 종합.예제10.board.service.ChatService;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat")
    public List<ChatDto> chatPrint(@RequestParam int bno){
        List<ChatDto>list=chatService.chatPrint(bno);
        return list;
    }

    @PostMapping("/chat")
    public boolean add(@RequestBody ChatDto chatDto){
        boolean result = chatService.add(chatDto);
        return result;
    }
    @DeleteMapping("/chat")
    public boolean del(@RequestParam int cno){
        boolean result = chatService.del(cno);
        return result;
    }

    @PutMapping("/chat")
    public boolean update(@RequestBody ChatDto chatDto){
        boolean result = chatService.update(chatDto);
        return result;
    }









}
