package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repository.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.Optional;

@Service @Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // [1] 회원제 글쓰기
    public boolean write(BoardDto boardDto, String loginMid){
        BoardEntity saveEntity = boardDto.toEntity();

        // 저장하기 전에 FK 대입하기 ,
        Optional<MemberEntity>entityOptional =
                memberRepository.findByMid(loginMid);
        if (!entityOptional.isPresent()){
            return false;
        }
        // 저장할 게시물 엔티티에 set잠조엔티티(회원엔티티)
        saveEntity.setMemberEntity(entityOptional.get());


        BoardEntity savedEntity = boardRepository.save(saveEntity);
        if (savedEntity.getBno() >0){return true;}
        else {return false;}
    }
}
