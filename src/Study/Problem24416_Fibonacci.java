package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24416_Fibonacci {

    public static int fib(int n){

        if(n == 1 || n == 2){
            return 1;
        }


        return (fib(n-1) + fib(n-2));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < n; i++){
            f[i] = f[i-1] + f[i-2];
            cnt++;
        }
        System.out.print(fib(n) + " " + cnt);
    }
}
