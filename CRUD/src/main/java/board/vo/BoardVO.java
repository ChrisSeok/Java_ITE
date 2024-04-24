package board.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
	public class BoardVO  implements Serializable{
		private int post_id; //user_id 필드는 auto_increment라서 insert할때 값을 안줘도 에러 안남!
		private int user_id;
		private String title;
		private String content;
		private Timestamp created_at;
		
		//post_id, user_id, title, content, created_at

}

	
	

