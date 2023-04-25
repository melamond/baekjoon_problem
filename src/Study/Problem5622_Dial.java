package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 백준 5622 다이얼
public class Problem5622_Dial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String dial = br.readLine();

        int second = 0;
        for(int i = 0; i < dial.length(); i++){
            if(dial.charAt(i) == 'A' || dial.charAt(i) == 'B' || dial.charAt(i) == 'C') { // 2
                second += 3;
            } else if (dial.charAt(i) == 'D' || dial.charAt(i) == 'E' || dial.charAt(i) == 'F') { // 3
                second += 4;
            } else if (dial.charAt(i) == 'G' || dial.charAt(i) == 'H' || dial.charAt(i) == 'I') { // 4
                second += 5;
            } else if (dial.charAt(i) == 'J' || dial.charAt(i) == 'K' || dial.charAt(i) == 'L') { // 5
                second += 6;
            } else if (dial.charAt(i) == 'M' || dial.charAt(i) == 'N' || dial.charAt(i) == 'O' ) { // 6
                second += 7;
            } else if (dial.charAt(i) == 'P' || dial.charAt(i) == 'Q' || dial.charAt(i) == 'R' || dial.charAt(i) == 'S') { // 7
                second += 8;
            } else if (dial.charAt(i) == 'T' || dial.charAt(i) == 'U' || dial.charAt(i) == 'V') { // 8
                second += 9;
            } else if (dial.charAt(i) == 'W' || dial.charAt(i) == 'X' || dial.charAt(i) == 'Y' || dial.charAt(i) == 'Z') { // 9
                second += 10;
            } else {
                second += 11;
            }
        }
        System.out.print(second);
    }
}
