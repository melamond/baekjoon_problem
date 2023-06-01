package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9095_1p2p3 {

    static int[] arr = {1, 2, 3}; // 1, 2, 3의 배열
    static boolean[] check; // 1, 2, 3 각 부분을 사용했는지 체크할 boolean
    static int cnt; // 나타낼 수 있는 수열 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // test case

        for(int i = 0; i < t; i++){
            int num = Integer.parseInt(br.readLine()); // 1+2+3으로 나타낼 정수
            cnt = 0;
            dp( num, 0);
            System.out.println(cnt);
        }
    }

    static void dp(int n, int sum){ // n = 정수, sum = 배열의 합
        if(sum == n){ // 합이 정수에 도달하면
            cnt++;
            return;
        } else if (sum > n) { // 합이 정수를 초과하면
            return;
        }

        for(int k = 0; k < 3; k++){ // 1 ~ 3까지 더하고 다음 dp 불러온 뒤 복귀 후 더했던 값을 빼기
            sum += arr[k];
            dp(n, sum);
            sum -= arr[k];
        }

    }
}
