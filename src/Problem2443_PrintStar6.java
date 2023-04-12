import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2443번 별찍기 6 (브론즈 3)

public class Problem2443_PrintStar6 {
    public static void main(String[] args) throws IOException {
        // 입력 위한 BR 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 N 받기
        int n = Integer.parseInt(br.readLine());

        // 별 찍기 반복문
        // 별 2×N-1개, 둘째 줄에는 별 2×N-3개, ..., N번째 줄에는 별 1개
        // 마지막은 최소 1개 찍혀야 함

        // 공백을 찍어줄 위치를 표기할 정수 space


        for (int i = n; i > 0; i--){ // 줄 반복문 ( 감소식 )

            for(int k = n; k > i; k--){ // 공백 반복문 (감소식)
                // 처음에 n에 i를 대입하였고, 마지막 줄에는 반드시 별 1개가 찍히므로
                // 공백은 N-(반복문 시행횟수-1) 만큼 찍힌다
                // 오른쪽 공백은 찍히지만 왼쪽은 찍을 필요 없다
                System.out.print(" ");
            }
            for(int j = (2 * i) - 1; j > 0; j--){ // 별 반복문 ( 감소식 )
                // 처음에 i에 n을 대입했기 때문에, i가 감소식으로 시행되면 반복문이 한바퀴 돌때마다
                // -2와 동일한 효과를 낼 수 있다
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
