package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2522_Starring12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while (count < n){
            for (int i = n - count; i > 1; i--){
                System.out.print(" ");
            }
            for (int i = 0; i <= count; i ++){
                System.out.print("*");
            }
            count++;
            System.out.println();
        }
        while (count > 0){
            count--;
            for(int i = n - count; i > 0; i--){
                System.out.print(" ");
            }
            for(int i = count; i > 0; i--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
