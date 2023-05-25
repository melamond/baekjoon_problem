package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1021_RotateQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken()); // 덱 크기
        int peek = Integer.parseInt(st.nextToken()); // 뽑아낼 숫자 개수

        Deque<Integer> deque = new LinkedList<>(); // 정방향 덱
        for (int i = 1; i <= size; i++){
            deque.addLast(i);
        }
        //System.out.println(deque);

        Deque<Integer> revdeque = new LinkedList<>(); // 역방향 덱
        for(int i = size; i > 0; i--){
            revdeque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());

        int[] poll = new int[peek]; // 뽑아낼 숫자들
        for(int i = 0; i < peek; i++) poll[i] = Integer.parseInt(st.nextToken());
        int idx = 0; // poll idx
        int res = 0;


        while (idx < peek){
            int left = 1;
            int right = 0;
            while (deque.peekFirst() != poll[idx]){ // 정방향 덱이 찾는 수에 해당할 때까지
                deque.addLast(deque.pollFirst()); // 뽑아서 뒤로
                right++;
            }
            while (revdeque.peekFirst() != poll[idx]){
                revdeque.addLast(revdeque.pollFirst());
                left++;
            }

            deque.remove();
            revdeque.remove();
            // 정방향 뽑은 수와 역방향 뽑은 수중 더 작은 것을 결과에 더해줌
            if (left < right) res += left;
            else res+=right;
            idx ++;
        }
        System.out.println(res);
    }
}
