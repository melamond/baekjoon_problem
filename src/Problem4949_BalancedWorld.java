import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
백준 4949 균형잡힌 세상
( -> push
) -> pop
형식으로 스택 구현
 */
public class Problem4949_BalancedWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String result = new String();
        Stack<String> parent = new Stack<>();

        String input;
        while (true){ // '.' 하나만 입력할때까지 반복
            input = br.readLine();
            result = "yes";
            parent.clear();
            if(input.equals(".")){
                break;
            }
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == '('){
                    parent.push("(");
                } else if (input.charAt(i) == '[') {
                    parent.push("[");
                } else if (input.charAt(i) == ')') {
                    if(parent.isEmpty()){
                        result = "no";
                        break;
                    } else {
                        if(parent.pop() != "("){
                            result = "no";
                            break;
                        }
                    }
                } else if (input.charAt(i) == ']') {
                    if(parent.isEmpty()){
                        result = "no";
                        break;
                    } else {
                        if(parent.pop() != "["){
                            result = "no";
                            break;
                        }
                    }
                } else if(input.charAt(i) == '.'){
                    if(!parent.isEmpty()){ // .이왔는데 스택이 차있으면
                        result = "no";
                    }
                }
            }
            System.out.println(result);
        }
    }
}
