package baekjoon;

import java.time.LocalDate;
import java.util.Scanner;

public class Problem1924 {
	public static void main(String[] args) {
		
		// 기준점은 2007년 1월 1일 월요일
		// 자바 패키지 사용하여 요일을 알아내자
		// LocalDate time = LocalDate.of(2007, 1, 1);
		
		// 아래 주석은 2007.1.1 의 요일을 체크하는 문장이다
		// System.out.println(time.getDayOfWeek()); // MONDAY
		
		// 스캐너를 통해 X월 Y일 을 입력받자
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		// X월 Y일을 LocalDate를 통해 받아보자
		// 년도는 2007년 고정이다
		LocalDate iTime = LocalDate.of(2007, x, y);
		
		// getDayOfWeek()는 Enum (열거형)으로 출력하므로
		// String에 값을 받을수없다.
		// 그러므로 .getValue()를 통해 정수형으로 바꿔주자
		// 월요일 (1) ~ 일요일 (7)
		int k = iTime.getDayOfWeek().getValue();
		
		String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		for(int i = 1; i <= 7; i++) {
			if(i == k) { // 만약 월~일 중 하나와 같다면
				System.out.println(day[i-1]);
			}
		}
	}
}