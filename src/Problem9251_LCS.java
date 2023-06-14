import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9251_LCS {
    // 최장 공통 부분 수열 문제

    static char[] arr1; // 첫번째 문자열의 파싱
    static char[] arr2; // 두번째 문자열의 파싱

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine(); // 첫번째 문자열
        String str2 = br.readLine(); // 두번째 문자열

        String str = new String();
        if(str1.length() < str2.length()){
            str = str1;
            str1 = str2;
            str2 = str;
        }
        arr1 = new char[str1.length()]; // 파싱
        arr2 = new char[str2.length()];

        for(int i = 0; i < str1.length(); i++){
            arr1[i] = str1.charAt(i);
        }
        for(int i = 0; i < str2.length(); i++){
            arr2[i] = str2.charAt(i);
        }
        int[][] result = new int[arr1.length][arr2.length];
        int res = 0;

        for(int i = 0; i < arr1.length; i++){

            for(int j = 0; j < arr2.length; j++){
                if(arr1[i] == arr2[j]){ // X[i] = Y[j] 일때
                    if(i != 0 && j != 0){
                        result[i][j] = result[i-1][j-1] + 1;
                    }else {
                        result[i][j] ++;
                    }
                }else {
                    if(i != 0 && j != 0) result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                    else if (i == 0 && j != 0) {
                        result[i][j] = result[i][j-1];
                    } else if (i != 0 && j == 0) {
                        result[i][j] = result[i-1][j];
                    }else {
                        result[i][j] = 0;
                    }
                }
                if(res < result[i][j]) res = result[i][j];
            }

        }


        System.out.println(res);
    }
    // 만약 arr1[] 과 같은 값을 못찾았으면, 이전 idx2 값을 다시 idx2에 넣어주고 재귀해야 함
    // ex : VREGDFELK / VLSKD = 기대값 3
    // V를 첫번째에서 찾고 R을 찾아보지만 R이 없으면 idx2는 V의 인덱스부터 다시 시작
    // TACCTAAAA / AAACATCGT = 4
}
