package manager2.department.service;

import com.manager2.department.dto.deDTO;
import com.manager2.department.entity.deEntity;
import com.manager2.department.repository.deRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor@Transactional
public class deService {

    private final deRepository derepository;

    //c
    public boolean add(deDTO dedto){
        deEntity deentity = new deEntity();
        deentity.setDname(dedto.getDname());
        deEntity saved = derepository.save(deentity);
        if (saved.getDid()>=1){return true;}
        return false;
    }

    //r
    public List<deEntity> print1(){
        return derepository.findAll();
    }

    //u
    public boolean update1(Long did , deDTO dedto){
        deEntity de = derepository.findById(did).orElse(null);
        if (de==null){return false;}
        de.setDname(dedto.getDname());
        return true;
    }

    //d
    public boolean delete1(Long did){
        derepository.deleteById(did);
        return true;
    }
}
