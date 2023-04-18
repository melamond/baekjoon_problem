import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem11653_Factorization {
    // 백준 문제 11653 소인수분해 (수학 문제)
    // 정수 N의 소인수 분해 결과를 한줄씩 출력하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        ArrayList<Integer> prime = new ArrayList<Integer>();
        /*
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                prime.add(i);
                num /= i;
            }
        }
         */
        int k = 2;
        while (true){
            if(num % k == 0){
                prime.add(k);
                num /= k;
            }else if(num % k != 0){
                k++;
            }
            if(k > num)
                break;
        }
        for(int i : prime)
            System.out.println(i);
    }
}
