import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1929_FindPrimeNumber {
    /* 백준 1929 소수 구하기 (수학문제, 에라토스테네스의 체)
     1이상 100만 이하의 M과 N 사이의 소수를 모두 출력하라
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for(int i = start; i <= end; i++){
            boolean result = true;
            for(int j = 2; j <= (int)Math.sqrt(i); j++){ // i보다 작은 합성수는 i의 제곱근의 배수를 제거하면 된다
                if (i % j == 0 || i == 1){
                    result = false;
                }
            }
            if(i == 2 || i == 3 || i == 5 || i == 7){
                result = true;
            }
            if (result == true){
                System.out.println(i);
            }
        }
        System.out.println(1/10);
    }

}
