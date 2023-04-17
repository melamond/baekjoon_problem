import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Problem2869_SnailWantsToClimb {
    public static void main(String[] args) throws IOException{
        // 백준 문제 달팽이는 올라가고 싶다 (브론즈 1) 수학 문제
        // 높이 V미터인 나무를 낮에 A미터 올라가고 밤에 B미터 미끄러지는 달팽이
        // 올라가는데 걸리는 일수를 출력하자

        // 첫째 줄에 A, B, V를 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int result = 0;
        if((v-b) % (a-b) == 0){
            result = (v-b)/(a-b); // V-A 가 아니라 V-B임을 주의하자!!!
        }else{
            result = ((v-b)/(a-b))+1;
        }
        System.out.print(result);
    }
}
