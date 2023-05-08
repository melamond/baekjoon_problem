package Study;

import java.io.*;
public class Problem10174_Palindrome {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){

            String str = br.readLine();
            str = str.toLowerCase();
            String palindrome = null;
            int start = 0;
            int end = str.length() - 1;
            while (true){
                if(str.charAt(start) == str.charAt(end)){
                    start++;
                    end--;
                }else {
                    palindrome = "No";
                    break;
                }
                if(end - start < 1){ // 문제없이 end 포인터와 start 포인터가 교차하면
                    palindrome = "Yes";
                    break;
                }
            }
            System.out.println(palindrome);
        }
    }
}
