package workshop04.calc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 5~10까지의 정수형 데이터를 입력 받는다.
// 입력 받은 정수 값을 Calc class의 calculate()함수를 이용하여 1부터 입력 받은 숫자까지
// 짝수만 더하는 프로그램을 작성 한다.

public class Test02 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String line = st.nextToken();
		System.out.println(line);
		
	}
}
