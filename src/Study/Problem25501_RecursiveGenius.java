package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25501_RecursiveGenius {
    public static int count;
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) {
            return 1;
        }
        else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String str = null;
        for(int i = 0; i < t; i++){
            count = 0;
            str = br.readLine();
            System.out.println(isPalindrome(str) + " " + count);
        }
    }
}
