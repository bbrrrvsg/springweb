package example.prcatice.practice3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    int number= 0;
    List<AttendanceDto>list = new ArrayList<>();


    @PostMapping
    public boolean POST(@RequestBody AttendanceDto attendanceDto){
        System.out.println("AttendanceController.POST");
        System.out.println("attendanceDto = " + attendanceDto);
        return true;
    }

    @GetMapping
    public List<AttendanceDto>GET(@RequestParam String studentName,String date,String status){
        System.out.println("AttendanceController.GET");


        AttendanceDto attendanceDto = AttendanceDto
                .builder()
                .ano(++number)
                .studentName(studentName)
                .date(date)
                .status(status)
                .build();
        list.add(attendanceDto);

        return list;
    }

    @GetMapping("/detail")
    public AttendanceDto GET2(@RequestParam String studentName,String date,String status){
        System.out.println("AttendanceController.GET2");
        AttendanceDto attendanceDto = AttendanceDto
                .builder()
                .ano(++number)
                .studentName(studentName)
                .date(date)
                .status(status)
                .build();

        return attendanceDto;
    }

    @DeleteMapping
    public boolean DELETE(@RequestParam int ano){
        for(int i=0; i<list.size(); i++) {
            if (list.get(i).getAno() == ano) {
                list.remove(i);
                break;
            }
        }
        return true;
    }

//    @PutMapping
//    public boolean PUT(@RequestBody ){
//        for(int i=0; i<list.size(); i++) {
//            if (list.get(i).getAno() == ano) {
//                list.remove(i);
//                break;
//            }
//        }
//        return true;
//    }
}


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
class AttendanceDto{
    private int ano;
    private String studentName;
    private String date;
    private String status;

}