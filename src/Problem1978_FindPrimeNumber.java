import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1978_FindPrimeNumber {
    // 백준 문제 1978 소수 찾기 (수학 문제)
    // 주어진 N개의 수 중 소수가 몇개인 지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수의 개수 n
        int count = Integer.parseInt(st.nextToken());

        // 숫자들의 배열
        int[] arr = new int[count];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int countOfPrimeNumber = 0;
        for (int i = 0; i < count; i++){
            int factoring = 0;
            for(int j = 1; j <= arr[i]; j++){
                if(arr[i]%j == 0){
                    factoring++;
                }
            }
            if(factoring==2){
                countOfPrimeNumber++;
            }
        }
        System.out.print(countOfPrimeNumber);
    }
}
