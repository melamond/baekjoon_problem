package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem17608_Stick {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> integerStack = new Stack<>();

        for(int i = 0; i < n; i++){
            integerStack.push(Integer.parseInt(br.readLine()));
        }
        int num = integerStack.pop();
        int count = 1;
        while(!integerStack.isEmpty()){
            if(num < integerStack.peek()){
                num = integerStack.pop();
                count++;
            }else {
                integerStack.pop();
            }
        }
        System.out.print(count);
    }
}
