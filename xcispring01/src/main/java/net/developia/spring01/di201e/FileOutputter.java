package net.developia.spring01.di201e;

public interface FileOutputter {
	public void output(String msg) throws Exception;
	//파일로 출력하는 메서드
	//라이브러리화, 모듈성 강화하려면 (처리 방법 다양하게) throws.
	//여기서 try-catch하면 자바로밖에 못처리함
}
