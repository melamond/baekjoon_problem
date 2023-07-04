package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1195_Kickdown {
    public static void main(String[] args) throws IOException {
        // 짧은 수열의 앞에 0을 하나씩 붙여가면서 긴 수열과 모두 더하고 4가 되는 부분이 없으면 맞물림

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        if(ch1.length > ch2.length){
            gear(ch1, ch2);
        }else {
            gear(ch2, ch1);
        }
    }

    static void gear(char[] ch1, char[] ch2){

        int res = ch1.length + ch2.length;

        // 같은 위치의 char 값의 합이 100 이 안되도록

        // 첫 for 문은 짧은 수열의 마지막 글자가 긴 수열의 마지막 글자를 추월하기 직전까지
        for(int i = 0; i < ch1.length; i++){
            int temp = ch2.length - 1;
            int tres = ch1.length + ch2.length;

            if(ch1[i] + ch2[temp] != 100){ // 4 가 아니면
                int cnt = 0;
                for (int j = 0; j <= i && j <= temp; j++){

                    if(ch1[i - j] + ch2[temp - j] == 100){
                        break;
                    }
                    cnt++;

                    if(j == i || j == temp) {
                        if(res > tres - cnt) res = tres - cnt;
                    }
                }
            }

        }
        // 두번째 for문은 짧은 수열의 마지막 글자가 긴 수열을 추월한 순간부터
        for(int i = ch2.length - 1; i >= 0; i--){
            int temp = ch1.length - 1;
            int tres = ch1.length + ch2.length;
            if(ch2[i] + ch1[temp] != 100){
                int cnt = 0;

                for(int j = 0; j <= i; j++){
                    if(ch2[i - j] + ch1[temp - j] == 100){
                        break;
                    }
                    cnt++;
                    if(j == i) {
                        if(res > tres - cnt) res = tres - cnt;
                    }
                }
            }
        }
        // 만약 맞물리는 부분이 없다면 길이는 ch1 + ch2 가 정답
        System.out.println(res);
    }
}
