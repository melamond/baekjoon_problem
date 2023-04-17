import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Problem10773_Zero {
    public static void main(String[] args) throws IOException {
        // 백준 문제 10773번 제로
        // 첫 줄에 정수 K 를 받고, K 줄 수 만큼 정수를 기록하는 스택을 구현한다
        // 단, 0을 기록할 경우 0을 스택에 넣는 대신 가장 최근에 스택에 넣었던 정수를 하나 지운다.
        // K줄 만큼 기록이 끝나면 스택에 들어있는 정수의 합을 출력한다.
        // 0이 들어올 때는 무조건 지울 수 있는 수가 있다 (그러므로 첫째줄은 무조건 1이상임)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int kLength = Integer.parseInt(st.nextToken());

        int[] stack = new int[kLength+1];

        int count = 0;
        for (int i = 0; i < kLength; i++){
            st = new StringTokenizer(br.readLine());
            stack[count] = Integer.parseInt(st.nextToken());
            if(stack[count] == 0){ // 만약 최근값이 0 이면
                stack[count-1] = 0;
                count --;
            }else {
                count++;
            }
        }

        int sum = 0;
        for (int i = 0; i < stack.length; i++){
            sum += stack[i];
        }
        System.out.print(sum);
    }
}
