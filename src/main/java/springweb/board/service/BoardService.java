package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repository.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service @Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final FileService fileService;


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

        // ** 최종 디비에 엔티티를 save 하기전에 파일 첨부파일 존해하면 업로드  하기 **
        String fileName = fileService.upload(boardDto.getUploadFile());

        // 만약에 업로드 했다면 저장할 엔티티에 업로드된 파일명 저장하기
        if(fileName !=null){saveEntity.setBfile(fileName);}


        BoardEntity savedEntity = boardRepository.save(saveEntity);
        if (savedEntity.getBno() >0){return true;}
        else {return false;}
    }

    // [2] 전체조회
    public List<BoardDto> findAll( ){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"bno"))
                .stream() // .stream 이란 여러개 자료를 갖는 자료(리스트/배열) 들의 순차적 처리 지원함수
                .map(BoardEntity :: toDto)// map
                .toList(); //
    }
    // [3] 개별조회
    public BoardDto findById( Long bno ){
        return boardRepository.findById(bno)
                .orElse(null)
                .toDto(); // 엔티티
    }


}
