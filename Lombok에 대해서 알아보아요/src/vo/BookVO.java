package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//VO 만드는 과정을 간소화 시켜보자! Lombok으로!

@Getter // 이렇게 하면 해당 클래스 안의 모든 필드에 대해 getter와 setter를 만들어준다.
@Setter  // 필드 앞에 annotation 줘도 되고 이렇게 클래스 선언 앞에 써줘도 된다.
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 private 필드 인자로 받는 생성자
@RequiredArgsConstructor //NonNull로 잡혀있는 필드를 포함해서 생성자를 생성
@ToString //인스턴스의 필드를 문자열로 변환해주는 
//@Data // Setter, Getter, RequiredArgsConstructor, ToString 만들어준다.

public class BookVO {
// 원래방법	
//	private String bisbn;
//	private String btitle;
//	private int bprice;
//	private String bauthor;
//	
////생성자	
//	public BookVO() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public BookVO(String bisbn, String btitle, int bprice, String bauthor) {
//		super();
//		this.bisbn = bisbn;
//		this.btitle = btitle;
//		this.bprice = bprice;
//		this.bauthor = bauthor;
//	}
////getter,setter
//	public String getBisbn() {
//		return bisbn;
//	}
//
//	public void setBisbn(String bisbn) {
//		this.bisbn = bisbn;
//	}
//
//	public String getBtitle() {
//		return btitle;
//	}
//
//	public void setBtitle(String btitle) {
//		this.btitle = btitle;
//	}
//
//	public int getBprice() {
//		return bprice;
//	}
//
//	public void setBprice(int bprice) {
//		this.bprice = bprice;
//	}
//
//	public String getBauthor() {
//		return bauthor;
//	}
//
//	public void setBauthor(String bauthor) {
//		this.bauthor = bauthor;
//	}
	
	
	
//Lombok 사용	
	
//	@Getter private String bisbn; //이렇게 annotation을 인자 앞에 써도 됨
	
	@NonNull //생성자에 포함시킬 필드 앞에 NonNull 어노테이션 붙이기.
	private String bisbn;
	@NonNull
	private String btitle;
	private int bprice;
	private String bauthor;
}
