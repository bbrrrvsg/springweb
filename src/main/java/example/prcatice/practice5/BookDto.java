package example.prcatice.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookDto {
    private Integer bno;
    private String bname;
    private String bwriter;
    private String bpublisher;

}
