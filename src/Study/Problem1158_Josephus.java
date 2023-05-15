package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1158_Josephus {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken()); // 1~N 까지 원형 큐에서
        int k = Integer.parseInt(st.nextToken()); // K 번쨰 수 제거

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        int cnt = 0;
        int num = 0;
        int[] arr = new int[n];
        int idx = 0;
        while (!queue.isEmpty()){
            num = queue.poll();
            if(cnt < k-1){
                queue.offer(num);
                cnt++;
            }else {
                arr[idx] = num;
                idx++;
                cnt = 0;
            }
        }
        sb.append("<");
        for(int i = 0; i < n-1; i++){
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[n-1]).append(">");
        System.out.print(sb);
    }
}
