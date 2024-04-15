package booksearch.vo;

public class BookVO {
		//private 필드로 테이블의 모든 column 선언 (원래는 다 선언함..여기선 4개만)
		//테이블의 column이름과 여기의 필드명은 동일하게 한다.(다르게 해도 되긴 하는데 유지보수 어려움 -추가적인 코드 넣어줘야댐)
		private String bisbn;
		private String btitle;
		private int bprice;
		private String bauthor;
		
//생성자	
		public BookVO() {
		}
		
		public BookVO(String bisbn, String btitle, int bprice, String bauthor) {
			super();
			this.bisbn = bisbn;
			this.btitle = btitle;
			this.bprice = bprice;
			this.bauthor = bauthor;
		}
		

		
		
		
//getter, setter
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
	
}
