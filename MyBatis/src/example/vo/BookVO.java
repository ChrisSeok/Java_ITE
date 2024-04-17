package example.vo;
//VO - 데이터 담는 객체 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok annotation
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookVO {
	private String bisbn;
	private String btitle;
	private int bprice;
	private String bauthor;

	
}
