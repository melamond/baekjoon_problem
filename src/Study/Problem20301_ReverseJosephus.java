package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem20301_ReverseJosephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken()); // N
        int k = Integer.parseInt(st.nextToken()); // K (삭제할 인덱스)
        int m = Integer.parseInt(st.nextToken()); // M (반전할 카운트)

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= length; i++){
            deque.addLast(i);
        }

        int idx = 0;
        int reverse = 0;
        boolean reverseBoolean = false;

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){ // 덱이 빌 때 까지 반복
            if(!reverseBoolean && idx != k-1){ // 반전 하기 전, idx가 k가 아니면
                idx++;
                deque.addLast(deque.removeFirst()); // 앞에 걸 뒤로
            } else if (!reverseBoolean && idx == k-1) { // 반전 하기 전, idx가 k면
                idx = 0;
                reverse++;
                sb.append(deque.removeFirst() + "\n"); // 앞의 걸 삭제
            } else if (reverseBoolean && idx != k-1) { // 반전 후, idx가 k 가 아니면
                idx++;
                deque.addFirst(deque.removeLast()); // 뒤에 걸 앞으로
            } else if (reverseBoolean && idx == k-1) { // 반전 후 idx가 k 면
                idx = 0;
                reverse++;
                sb.append(deque.removeLast() + "\n"); // 뒤에 걸 삭제
            }
            if(reverse == m && !reverseBoolean) {// reverse 가 m이고 boolean 이 false면
                reverse = 0;
                reverseBoolean = true;
            } else if (reverse == m && reverseBoolean) {
                reverse = 0;
                reverseBoolean = false;
            }
        }
        System.out.print(sb);
    }
}
