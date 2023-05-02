package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1051_NumSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            String[] strings = str.split("");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }
        // System.out.println(Arrays.deepToString(arr)); // 배열 내부 확인
        int result = 1;
        int length = 0;


        for (int i = 0; i < m; i++) {

            for (int k = i+1; k < m; k++) {

                for(int j = 0; j < n; j++){

                    if (arr[j][i] == arr[j][k]){ // 가로축에서 같은 수 발견시

                        length = k - i;

                        try{

                            if(arr[j][i] == arr[j][k] && arr[j][k] == arr[j+length][i] && arr[j+length][i] == arr[j+length][k]){ // 세로 축의 꼭지점과도 같으면

                                length += 1;

                                if(result < length * length){
                                    result = length * length;
                                }

                            }

                        }catch (Exception e){

                        }

                    } else {
                        if(result < 1){
                            result = 1;
                        }
                    }

                }

            }

        }

        System.out.print(result);


    }
}

