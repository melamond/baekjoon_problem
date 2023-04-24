package Study;
// 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2577_NumofNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());

        String result = Integer.toString(a * b * c);
        int[] arr = new int[10];
        for(int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0') {
                arr[0]++;
            } else if (result.charAt(i) == '1') {
                arr[1]++;
            } else if (result.charAt(i) == '2') {
                arr[2]++;
            } else if (result.charAt(i) == '3') {
                arr[3]++;
            } else if (result.charAt(i) == '4') {
                arr[4]++;
            } else if (result.charAt(i) == '5') {
                arr[5]++;
            } else if (result.charAt(i) == '6') {
                arr[6]++;
            } else if (result.charAt(i) == '7') {
                arr[7]++;
            } else if (result.charAt(i) == '8') {
                arr[8]++;
            } else if (result.charAt(i) == '9') {
                arr[9]++;
            }
        }

        for(int i : arr)
            System.out.println(i);
    }
}
