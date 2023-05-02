package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem12605_FlipWord {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for(int i = 1; i <= n; i++){
            String str = br.readLine();
            String[] pStr = str.split(" ");
            Stack<String> stack = new Stack<>();

            for(int k = 0; k < pStr.length; k++){
                stack.push(pStr[k]);
            }

            System.out.print("Case #"+i+": ");
            while (!stack.isEmpty()){
                System.out.print(stack.pop());
                if(!stack.isEmpty()){
                    System.out.print(" ");
                }else {
                    System.out.println();
                }
            }
        }
    }
}
