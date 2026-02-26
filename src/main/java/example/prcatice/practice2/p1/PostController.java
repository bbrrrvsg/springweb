package example.prcatice.practice2.p1;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/practice2")
public class PostController {

    List<Map<String,String>>list=new ArrayList<>();

    @PostMapping("/post")
    public boolean doPost(){
        System.out.println("PostController.doPost");
        Map<String ,String>map1 = new HashMap<>();
        map1.put("bno","1");
        map1.put("btitle","제목1");
        list.add(map1);
        System.out.println("map1 = " + map1);
        return true;
    }

    @GetMapping("/post")
    public Map<String, String> doGet(){
        System.out.println("PostController.doGet");
        Map<String ,String>map1 = new HashMap<>();
        map1.put("bno","1");
        map1.put("btitle","제목1");
        list.add(map1);
        return map1;
    }
    @GetMapping("/post/view")
    public List<Map<String,String>> doGet1(){
        System.out.println("PostController.doGet");
        Map<String ,String>map1 = new HashMap<>();
        map1.put("bno","1");
        map1.put("btitle","제목1");
        list.add(map1);
        return list;
    }
    @PutMapping("/post")
    public boolean doput(){
        System.out.println("PostController.doput");
        Map<String ,String>map1 = new HashMap<>();
        map1.put("bno","1");
        map1.put("btitle","제목1");
        list.add(map1);
        return false;
    }

    @DeleteMapping("/post")
    public int dodelete(){
        System.out.println("PostController.dodelete");
        return 1;
    }

}
