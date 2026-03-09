package 종합.예제10.board.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import 종합.예제10.board.dto.ChatDto;
import 종합.예제10.board.entity.ChatEntity;
import 종합.예제10.board.repository.ChatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public List<ChatDto> chatPrint(int bno){
        chatRepository.findById(bno);
        List<ChatEntity>list1= chatRepository.findAll();
        List<ChatDto>list2=new ArrayList<>();

        list1.forEach(chatEntity -> {
            if(chatEntity.getBno()==bno) {
                ChatDto chatEntity1 = chatEntity.toDto();
                list2.add(chatEntity1);
            }
        });
        return list2;
    }
    public boolean add( ChatDto chatDto){
        ChatEntity chatEntity = chatDto.toEntity();
        chatEntity= chatRepository.save(chatEntity);
        if (chatEntity.getCno()>=1)return true;
        return false;
    }
    public boolean del(int cno){
        Optional<ChatEntity>optional= chatRepository.findById(cno);
        if (optional.isPresent()){
            chatRepository.deleteById(cno);
            return true;

        }
        return false;
    }
    @Transactional
    public boolean update(ChatDto chatDto){
        Optional<ChatEntity>optional = chatRepository.findById(chatDto.getCno());
        if(optional.isPresent()){
            ChatEntity chatEntity = optional.get();
            chatEntity.setComment(chatDto.getComment());
            return true;
        }
        return false;

    }










}
