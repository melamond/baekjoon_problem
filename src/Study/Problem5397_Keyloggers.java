package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem5397_Keyloggers {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){

            Deque<String> pw = new LinkedList<>();
            Stack<String> stack = new Stack<>();

            String str = br.readLine();
            String[] st = str.split("");

            for(int k = 0; k < st.length; k++){

                if(st[k].equals("<")){ // 만약 < 일때
                    if(pw.isEmpty()){ // pw가 비었으면
                        continue;
                    } else { // pw가 비지 않았으면
                        stack.push(pw.removeLast()); // pw의 끝을 스택에 저장
                    }
                } else if (st[k].equals(">")) { // 만약 > 일때
                    if(stack.isEmpty()){ // 스택이 비었으면 (커서가 맨 끝이면)
                        continue;
                    } else { // 스택이 비지 않았으면 (커서가 맨 끝이 아니면)
                        pw.offer(stack.pop()); // 스택의 맨 위를 pw의 맨 끝에 저장
                    }
                } else if (st[k].equals("-")) { // 만약 - (백스페이스) 일때
                    if(pw.isEmpty()){ // pw가 비었으면
                        continue;
                    } else {
                        pw.removeLast();
                    }
                } else {
                    pw.offer(st[k]);
                }
            }
            Iterator iter = pw.iterator();
            while (iter.hasNext()){
                System.out.print(iter.next());
            }
        }
    }
}
