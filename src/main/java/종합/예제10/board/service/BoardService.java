package 종합.예제10.board.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.repository.BaordRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BaordRepository baordRepository;

    public boolean 등록(BoardDto boardDto){
        BoardEntity savedEntity = boardDto.toEntity();

        savedEntity = baordRepository.save(savedEntity);
        if (savedEntity.getBno()>=1){return true;}
        return false;
    }

    public List<BoardDto> 조회(){
        List<BoardEntity>list1=baordRepository.findAll();
        List<BoardDto>list2 = new ArrayList<>();

        list1.forEach(boardEntity -> {
            BoardDto boardDto = boardEntity.toDto();
            list2.add(boardDto);
        });
        return list2;
    }

    public BoardDto 개별조회(int bno){

        Optional<BoardEntity>optional = baordRepository.findById(bno);
        if(optional.isPresent()){
            BoardEntity boardEntity = optional.get();
            BoardDto boardDto = boardEntity.toDto();
            return boardDto;
        }
        return null;
    }
    @Transactional
    public boolean 수정(BoardDto boardDto){
        Optional<BoardEntity>optional = baordRepository.findById(boardDto.getBno());
        if (optional.isPresent()){
            BoardEntity upEntity = optional.get();
            upEntity.setBtitle(boardDto.getBtitle());
            upEntity.setBcontent(boardDto.getBcontent());
            upEntity.setBwriter(boardDto.getBwriter());
            return true;
        }
        return false;
    }
    public boolean 삭제(int bno){
        Optional<BoardEntity>optional = baordRepository.findById(bno);
        if (optional.isPresent()){
            baordRepository.deleteById(bno);
            return true;
        }
        return false;
    }
}
