package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8958_OXQuiz {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){

            String str = br.readLine();

            int sum = 0;
            int o = 0;


            for(int k = 0; k < str.length(); k++){
                if(str.charAt(k) == 'O'){
                    o += 1;
                    sum += o;
                } else {
                    o = 0;
                }
            }

            System.out.println(sum);
        }
    }
}
