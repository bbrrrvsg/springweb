package example.prcatice.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //조회
    public List<MovieDto> mprint(){

        List<MovieEntity>list = movieRepository.findAll();
        List<MovieDto>list1 = new ArrayList<>();

        list.forEach(movieEntity -> {
            MovieDto movieDto1 = movieEntity.toDto();
            list1.add(movieDto1);
        });
        return list1;
    }

}
