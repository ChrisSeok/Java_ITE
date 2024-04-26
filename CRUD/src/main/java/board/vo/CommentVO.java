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
	public class CommentVO  implements Serializable{
		private int comment_id; //auto_increment 필드는 insert 할 때 값을 안줘도 에러 안남!
		private int user_id;
		private int post_id; 
		private String comment_text;
		private Timestamp created_at;

}

	