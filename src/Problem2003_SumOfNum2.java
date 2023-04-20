import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2003_SumOfNum2 {
    public static void main(String[] args) throws IOException {
        // 백준 2003 수들의합 2 (브루트포스 알고리즘, 투 포인터)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrLength = Integer.parseInt(st.nextToken());
        int arrSummary = Integer.parseInt(st.nextToken());;

        int[] arrInt = new int[arrLength];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrLength; i++){
            arrInt[i] = Integer.parseInt(st.nextToken());
        }

        int howMany = 0;
        for(int i = 0; i < arrLength; i++){
            int sum = 0;

            for (int idx = i; idx < arrLength; idx ++){
                sum += arrInt[idx];
                if(sum == arrSummary){
                    howMany++;
                    break;
                }
            }
        }
        System.out.print(howMany);
    }
}
