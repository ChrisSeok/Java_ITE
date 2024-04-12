package book.vo;

//얘는 VO로 사용할거야
//데이터를 표현하는 클래스

public class BookVO {
// VO는 항상 이렇게 만든다.
	
	
// DB안에 있는 컬럼명과 똑같다!
// 일반적으로 VO는 해당 VO가 표현하는 테이블의 컬럼명과 일치시킨다. 
	private String bisbn; 
	private String btitle; 
	private int bprice; //필드명과 타입 모두 DB와 맞춘다. 
	private String bauthor;
	
	public BookVO() {
		
	}

	public BookVO(String bisbn, String btitle, int bprice, String bauthor) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bauthor = bauthor;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	@Override
		public String toString() {
			return bisbn + ":" + btitle + ":" + bprice + ":" + bauthor;
		}
}





