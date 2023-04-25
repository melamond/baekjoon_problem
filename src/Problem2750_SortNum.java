
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2750_SortNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int integer;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            integer = sc.nextInt();
            if(arr.contains(integer)){
                continue;
            }
            arr.add(integer);
        }
        Collections.sort(arr);

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
}
