package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem7489_Factorial {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            BigInteger factorial = BigInteger.ONE;
            for(int k = 1; k <= n; k++){
                factorial = factorial.multiply(BigInteger.valueOf(k));
            }
            String str = factorial.toString();
            char ch = '0';
            for(int k = 0; k < str.length(); k++){
                if(str.charAt(k) != '0'){
                    ch = str.charAt(k);
                }
            }
            System.out.println(ch);
        }
    }
}