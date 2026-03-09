package example.day06;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional // 여러개 setter을 사용가기 떄문에 단일실행으로 하기위해
public class GoodsService {
    @Autowired
    private GoodsRepositoey goodsRepositoey;

    //저장
    public boolean 저장(GoodsDto goodsDto){
        //dto-->entity 변환 후 저장
        // GoodsEntity goodsEntity = goodsDto.toEntity();
        // GoodsEntity saveEntity = goodsRepositoey.save(goodsEntity);

        //JPA save이용하여 엔티티 insert 하기
        GoodsEntity saved = goodsRepositoey.save(goodsDto.toEntity());
        //save 결과에 pk 여부 성공판단
        if(saved.getGno()>=1) return true;
        return false;
    }

    //수정
    @Transactional // 여러개 setter을 사용가기 떄문에 단일로 사용하려고 사용
    public boolean 수정(GoodsDto goodsDto){
        //수정할 엔티티의 pk번호 확인
        int updatepk = goodsDto.getGno();
        //수정할 엔티티 찾기 --> 영속성
        Optional<GoodsEntity>optional=goodsRepositoey.findById(updatepk);
        //만약에 찾은 엔티티가 존재하면
        if(optional.isPresent()){
            GoodsEntity updateEntity = optional.get();// 엔티티를 꺼내기
            updateEntity.setGdesc(goodsDto.getGdesc());
            updateEntity.setGname(goodsDto.getGname());
            updateEntity.setGprice(goodsDto.getGprice()); // 3개중에 setter에서 하나라도 문제 발생시 전체 취소
            return true;
        }else {
            return false;
        }
    }
}
