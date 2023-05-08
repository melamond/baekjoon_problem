package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2163_CutChocolate {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[2];
        /* 가로 세로 중 */
        int n = 0; // 작은 쪽
        int m = 0; // 큰 쪽
        int count = 0;

        for(int i = 0; i < 2; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(arr[0] > arr[1]){
            n = arr[1];
            m = arr[0];
        }else {
            n = arr[0];
            m = arr[1];
        }

        count += n - 1;
        for(int i = 0; i < n; i++){
            count += m-1;
        }

        System.out.print(count);
    }
}
