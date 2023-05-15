package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15649_NM {
    static int n;
    static int[] arr;
    static boolean[] check;

    public static void dfs (int n, int m, int cnt){
        if(cnt == m){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!check[i]){
                check[i] = true;
                arr[cnt] = i+1;
                dfs(n, m, cnt+1);

                check[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 1~N 까지
        int m = Integer.parseInt(st.nextToken()); // M개의 수를 고른 수열 모두


        arr = new int[m];
        check = new boolean[n];
        dfs(n, m, 0);
    }
}
