package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2839_Sugar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 3키로와 5키로만 들고갈 때 최대한 적은 봉지를 들고가기
        int three = 3;
        int five = 5;

        int result = 9999;
        // 5 kg 가 더 크므로, 5kg 를 우선 하나 빼고 3이나 5로 모두 나뉘는지 체크
        for(int i = n / 5; i >= 0; i--){ // 5를 나누는 것이 몫이 가장 작으므로, n을 5로 나눈 값에 대해 반복문
            int cnt = i; // 임시결과 값의 기본값은 5kg 설탕을 넣은 횟수

            int num = n - 5 * i; // 처음 받은 n에서, 5kg 설탕의 무게를 뺀 횟수
            if(num % 3 == 0){ // n에서 5kg 설탕 i 개를 뺀 무게를 3으로 나눈 몫이 0인 경우
                cnt += num / 3; // 임시 결과 값에 3kg 설탕을 넣은 횟수를 더함
                if(result > cnt) result = cnt; // 반복문 블럭 바깥의 변수에 저장해둔 값보다 작으면 대체함
                // 만약 5*i + 3*n 에 해당되지 않으면, 이 if 문으로 진입하지 않으므로 값은 변하지 않음
            }
        }
        if(result == 9999) result = -1;
        System.out.print(result);
    }
}
