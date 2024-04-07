package workshop04;
//입출력 다루기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test04_BufferedReader {
	
	public static void main(String[] args) throws IOException { // throws는 자신을 호출하는 메서드에 예외처리를 위임한다. 이 경우 어디서?
		// throw 는 강제로 예외 발생시켜서 상위 블럭이나 catch문으로 예외를 던진다.
		
		// 		Scanner는 느려서 잘 안쓴다!
		//		Scanner scanner = new Scanner(System.in);

		int row = 0;
		int col = 0;
		double sum = 0;
		double avg;
		boolean incorrect = true;

			while(incorrect) {
				// BufferedReader로 입력값 받고 
				BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));

				// StringTokenizer로 입력받은 라인을 분리
				StringTokenizer st = new StringTokenizer(Br.readLine());


				//입력 받은 데이터가 2개 미만 또는 2개 초과로 입력 하면 “다시 입력 하세요” 출력
				if (st.countTokens()>2 || st.countTokens()<2) {
					System.out.println("다시 입력하세요");
				}
			
				
					
//				//1~5이외의 숫자가 입력 될 경우 “숫자를 확인 하세요” 출력
//
//				//			while(st.hasMoreTokens()) {
//				//			int num = Integer.parseInt(st.nextToken());
//				//			if (num<1 || num>5) {
//				//				System.out.println("숫자를 확인 하세요");
//				//			}
//
//
				//		원시 타입(primitive type)과 그에 해당하는 래퍼 클래스(wrapper class) 간의 변환을 자동으로 처리할 수 있습니다.
				row = Integer.parseInt(st.nextToken());
				col = Integer.parseInt(st.nextToken());

				if (row<1 || row>5 ||col<1 || col>5 ) {
					System.out.println("숫자를 확인하세요");
				}
				else {
					System.out.println("좋았어!");
					incorrect = false;
				}
			}
//			System.out.printf("%d %d\n",row, col);
//
//			
			//		입력 받은 두개의 정수를 이용하여 2차원 배열을 생성한다.
			int[][] arr = new int[row][col];
			
			//		5) 2차원 배열에 1~5까지의 랜덤한 숫자(중복허용)를 넣는다.
			Random rand = new Random();
			for (int i=0;i<row;i++) {
				for (int j=0;j<row;j++) {
					arr[i][j] = rand.nextInt(5)+1; //0 ~ 5미만 +1
				}
			}
			
			
//			6) 배열의 내용을 출력 한다.
			for (int i=0;i<row;i++) {
				for (int j=0;j<col;j++) {
					System.out.printf("%d ",arr[i][j]);
					sum+=arr[i][j];
				}
				System.out.println();
			}
			
			
			avg = sum/(row*col);
			System.out.printf("sum: %.1f \n avg: %.1f",sum,avg);
			
//			
			
			//		7) 배열의 총합과 평균을 출력 한다.


		}
	} 



