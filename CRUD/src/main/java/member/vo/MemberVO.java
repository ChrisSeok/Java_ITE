package member.vo;

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
	public class MemberVO {
		private String user_id; //user_id 필드는 auto_increment라서 insert할때 값을 안줘도 에러 안남!
		private String user_loginid;
		private String user_pw;
		private String user_name;
		
		

}

	
	

