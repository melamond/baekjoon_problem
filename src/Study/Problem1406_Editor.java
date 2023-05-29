package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Problem1406_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<>(); // Char형 List

        for(int i = 0; i < str.length(); i++) list.add(str.charAt(i));
        //System.out.println(list);
        ListIterator<Character> iterator = list.listIterator(); // list의 반복자
        while (iterator.hasNext()) iterator.next(); // 커서 맨뒤로

        int t = Integer.parseInt(br.readLine()); // 명령 횟수

        for(int i = 0; i < t; i++){
            String order = br.readLine(); // 명령

            if(order.charAt(0) == 'L' && iterator.hasPrevious()){ // 명령이 L이면
                iterator.previous();
            } else if (order.charAt(0) == 'D' && iterator.hasNext()) {
                iterator.next();
            } else if (order.charAt(0) == 'B' && iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove(); // 한칸 왼쪽으로 간 뒤에, 가장 마지막으로 움직인 반복자가 가리키는 대상 삭제
            } else if (order.charAt(0) == 'P') {
                iterator.add(order.charAt(2));
            }
        }
        StringBuilder sb = new StringBuilder();
        iterator = list.listIterator();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        System.out.print(sb);
    }
}
