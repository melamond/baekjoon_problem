package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2587 {
	public static void main(String[] args) {
		// 입력 받기 위한 스캐너 선언
		// 필요에 따라 버퍼 등으로 변경 가능.
		Scanner sc = new Scanner(System.in);
		
		// 5개의 자연수를 받기 위한 배열과 for문 선언
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 배열의 오름차순
		Arrays.sort(arr);
		
		// 5개 수의 평균값을 구하기 위해 먼저 총합을 받자
		int total = 0;
		for(int j = 0; j < 5; j++) {
			total += arr[j];
		}
		
		// 평균값 선언
		int avg = total / 5;
		System.out.println(avg);
		System.out.println(arr[2]);
	}
}
