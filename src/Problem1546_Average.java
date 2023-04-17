import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
public class Problem1546_Average {
    // 백준 문제 1546번 평균 (수학, 사칙연산)
    // 점수를 조작해라
    // 점수 / 최댓값 * 100
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int subject = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] score = new int[subject];
        for(int i = 0; i < score.length; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score); // 오름차순 정렬

        double average = 0;
        int topscore = score[score.length-1];
        for(int i = 0; i < score.length; i++)
            average += score[i];

        average = average / topscore * 100 / subject;
        System.out.print(average);
    }
}
