package Study;

import java.io.*;
import java.util.*;
public class Problem5397_Keyloggers_New {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // testcase
        for(int i = 0; i < t; i++){
           String str = br.readLine();
           String[] pstr = str.split(""); // parse
           LinkedList<String> pw = new LinkedList<>(); // password
           ListIterator<String> listIterator = pw.listIterator();
           StringBuilder sb = new StringBuilder();

           for(String st : pstr){
               if(st.equals("<") && listIterator.hasPrevious()){
                   listIterator.previous();
               } else if (st.equals(">") && listIterator.hasNext()) {
                   listIterator.next();
               } else if (st.equals("-") && listIterator.hasPrevious()) {
                   listIterator.previous();
                   listIterator.remove();
               } else if (!st.equals("<") && !st.equals(">") && !st.equals("-")){
                   listIterator.add(st);
               }
           }
            for(String st : pw){
                sb.append(st);
            }
            System.out.print(sb);
            System.out.println();
        }
    }
}
