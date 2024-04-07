package buffertest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BufferTest {
	public static void main(String[] args) throws IOException {
		int num1, num2;
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = "1 2 3 4 5";
//		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 문자열을 특정 기준으로 분리한다. 두번째 인자 없으면 공백 기준.
		StringTokenizer st = new StringTokenizer(input); 
//		System.out.println(st.nextToken()); // 첫번째 토큰 확인
		
		System.out.println("공백으로 분리된 토큰 개수: "+st.countTokens()); // 토큰 개수 리턴
		
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
		
		num1 = Integer.parseInt(st.nextToken()); // 토큰이 문자열이기 때문에 정수로 변환해줘야 한다.
		num2 = Integer.parseInt(st.nextToken()); // 토큰이 문자열이기 때문에 정수로 변환해줘야 한다.
		
		System.out.printf("%d,%d",num1,num2);		
//				
//        int tokenCount = tokenizer.countTokens();
//        int[] numbers = new int[tokenCount];
//
//        // 토큰들을 정수형 변수에 저장                                                                                                                                      
//        int index = 0;
//        while (tokenizer.hasMoreTokens()) {
//            // StringTokenizer에서 토큰을 가져와서 정수로 변환하여 배열에 저장
//            numbers[index++] = Integer.parseInt(tokenizer.nextToken());
//        }
//
//        // 저장된 정수형 변수 출력
//        System.out.println("저장된 정수형 변수:");
//        for (int number : numbers) {
//            System.out.println(number);
//        }
//				


	}
}


