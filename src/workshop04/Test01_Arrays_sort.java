package workshop04;
import java.util.*;

//Arrays 클래스 사용법을 익혀보자
// Arrays 클래스의 sort 메서드로 정렬하기, Collections의 reverseOrder로 내림차순 정렬.
//Collections 인터페이스 사용시, wrapper 클래스의 자료형을 쓰는것이 좋다.

public class Test01_Arrays_sort {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int len = arr.length;
		
		Integer[] intarr = new Integer[len];
		
		for (int i=0;i<len;i++) {
		intarr[i] = arr[i];
	}
		Arrays.sort(intarr, Collections.reverseOrder());

		
		for (Integer each : intarr) {
			System.out.print(each+" ");
		}
	}
}
