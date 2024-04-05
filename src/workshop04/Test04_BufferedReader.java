package workshop04;
//입출력 다루기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test04_BufferedReader {
	public static void main(String[] args) throws IOException {
		// 		Scanner는 느려서 잘 안쓴다!
		//		Scanner scanner = new Scanner(System.in);
		
		int row, col;
		
		// BufferedReader로 입력값 받고 
		BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));

		// StringTokenizer로 입력받은 라인을 분리, 필드에 저장
		
		StringTokenizer st = new StringTokenizer(Br.readLine());
		
		
//		 입력 받은 데이터가 2개 미만 또는 2개 초과로 입력 하면 “다시 입력 하세요” 출력
		if (st.countTokens()>2 || st.countTokens()<2) {
			System.out.println("다시 입력하세요");
		}

			
		//1~5이외의 숫자가 입력 될 경우 “숫자를 확인 하세요” 출력
//		원시 타입(primitive type)과 그에 해당하는 래퍼 클래스(wrapper class) 간의 변환을 자동으로 처리할 수 있습니다.
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (num<1 || num>5) {
				System.out.println("숫자를 확인 하세요");
			}
		}
//		입력 받은 두개의 정수를 이용하여 2차원 배열을 생성한다.
//		5) 2차원 배열에 1~5까지의 랜덤한 숫자(중복허용)를 넣는다.
//		6) 배열의 내용을 출력 한다.
//		7) 배열의 총합과 평균을 출력 한다.
		
	}
}
