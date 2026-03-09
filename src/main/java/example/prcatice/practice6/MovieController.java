package example.prcatice.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    //등록
    @GetMapping("/movie")
    public List<MovieDto> mprint(){
        List<MovieDto> result = movieService.mprint();
        return result;
    }



}
