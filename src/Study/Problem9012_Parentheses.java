package Study;

import java.io.*;
import java.util.*;
public class Problem9012_Parentheses {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Character> parent;

        String str = null;
        String result;
        for(int i = 0; i < n; i++){
            str = br.readLine();
            parent = new Stack<>();
            result = "YES";
            for(int k = 0; k < str.length(); k++){
                if(str.charAt(k) == '('){
                    parent.push('(');
                } else if (str.charAt(k) == ')') {
                    if(parent.isEmpty()){
                        result = "NO";
                        break;
                    } else if (parent.peek() == '(') {
                        parent.pop();
                    }
                }
            }
            if(parent.size() > 0){
                result = "NO";
            }
            System.out.println(result);
        }
    }
}
