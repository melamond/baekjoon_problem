package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1003_Fibonacci {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 0 <= T <= 40

        for(int i = 0; i < t; i++){ // test case 만큼 반복
            int n = Integer.parseInt(br.readLine());


            // n + 2 = ( n + 1 ) + n
            // n = (n - 1) + (n - 2)

            int[][] arr = new int[t][2];

            int result = 0;
            int a = 0;
            int b = 1;

            if(n == 1){
                arr[i][1] = 1;
            } else if (n == 0) {
                arr[i][0] = 1;
            }


            for(int k = 2; k <= n; k++){
                result = a + b;
                a = b;
                b = result;
                arr[i][0] = a;
                arr[i][1] = b;
            }
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
