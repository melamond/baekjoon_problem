import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5585_Change {
    public static void main(String[] args) throws IOException {
        // 백준 5585 거스름돈 (그리디)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pay = Integer.parseInt(br.readLine());

        int max = 1000;
        int change = max - pay;
        int count = 0;
        while (change > 0){ // 거스름돈을 5엔으로 줄수 있을 때까지
            if (change % 5 > 0){
                change -= 1; // 1엔으로 거슬러주기
                count ++;
            } else if (change % 10 > 0) {
                change -= 5;
                count ++;
            } else if (change % 50 > 0) {
                change -= 10;
                count ++;
            } else if (change % 100 > 0) {
                change -= 50;
                count ++;
            } else if (change % 500 > 0) {
                change -= 100;
                count ++;
            } else {
                change -= 500;
                count ++;
            }
        }
        System.out.print(count);
    }
}
