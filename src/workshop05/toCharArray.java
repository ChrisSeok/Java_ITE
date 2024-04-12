package workshop05;

//String 클래스의 toCharArray() 메서드: 문자열을 문자 배열로 변환


public class toCharArray {
	public static void main(String[] args) {
		//프로그램 실행 시 eclipse argument로 공백이 없는 String 형태의 문자열을 받아 들인다 > args 사용
		String input = args[0];
		//입력 받은 문자열을 뒤에서부터 출력 하는 프로그램을 작성 한다.
		//단, String class의 toCharArray() 메소드를 이용한다.  
        //	toCharArray() : 문자열을 문자 배열로 변환
		char[] charr = input.toCharArray();
		
		for(int i=charr.length-1;i>=0;i--) {
			System.out.print(charr[i]);
		}
	}
}
