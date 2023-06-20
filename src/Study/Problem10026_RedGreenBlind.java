package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// N * N 의 격자 내에  R(빨강), G(초록), B(파랑) 로 이루어진 각 영역의 갯수
// 단, 적록 색약일 경우 R과 G는 같은 영역
// N <= 100
public class Problem10026_RedGreenBlind {
    static char[][] arr; // RGB
    // 일반시각
    static boolean[][] visitNormal;
    static int[] cntNormal = {0, 0, 0};
    // 색약시각
    static boolean[][] visitColor;
    static int[] cntColor = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /** INPUT **/
        arr = new char[n][n];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j);
            }
        } // INPUT END

        /** BFS NORMAL**/
        visitNormal = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visitNormal[i][j]){
                    bfsNormal(i, j);
                }
            }
        } // BFS NORMAL END
        /** BFS COLOR **/
        visitColor = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visitColor[i][j]){
                    bfsColor(i, j);
                }
            }
        } // BFS COLOR END

        int areaNormal = 0;
        for (int i : cntNormal) areaNormal += i;

        int areaColor = 0;
        for (int i : cntColor) areaColor += i;
        System.out.print(areaNormal + " " + areaColor);
    }

    /** 일반 시야 bfs (구현 완료) **/
    static void bfsNormal(int n, int m){
        char color = arr[n][m]; // 탐색할 색상

        int[] pn = {1, -1, 0, 0};
        int[] pm = {0, 0, 1, -1};
        Queue<Integer> queue = new LinkedList<>(); // 좌표값 Queue

        queue.add(n);
        queue.add(m);
        visitNormal[n][m] = true;

        /** Queue **/
        while (!queue.isEmpty()){
            int nowN = queue.poll();
            int nowM = queue.poll();

            for(int i = 0; i < 4; i++){
                int plusN = nowN + pn[i];
                int plusM = nowM + pm[i];

                // 배열 범위 밖일 경우
                if(plusN < 0 || plusN >= arr.length ||plusM < 0 || plusM >= arr[nowN].length) continue;
                // 색상이 다르거나 이미 방문한 경우
                if(arr[plusN][plusM] != color || visitNormal[plusN][plusM]) continue;

                visitNormal[plusN][plusM] = true;
                queue.add(plusN);
                queue.add(plusM);
            }
        } // Queue END

        // 구역 카운팅
        if(color == 'R') cntNormal[0]++;
        else if (color == 'G') cntNormal[1]++;
        else cntNormal[2]++;
    }

    static void bfsColor(int n, int m){
        // R = 82, G = 71, B = 66
        char color = arr[n][m]; // 탐색할 색상

        int[] pn = {1, -1, 0, 0};
        int[] pm = {0, 0, 1, -1};
        Queue<Integer> queue = new LinkedList<>(); // 좌표값 Queue

        queue.add(n);
        queue.add(m);
        visitColor[n][m] = true;

        /** Queue **/
        while (!queue.isEmpty()){
            int nowN = queue.poll();
            int nowM = queue.poll();

            for(int i = 0; i < 4; i++){
                int plusN = nowN + pn[i];
                int plusM = nowM + pm[i];

                // 배열 범위 밖일 경우
                if(plusN < 0 || plusN >= arr.length ||plusM < 0 || plusM >= arr[nowN].length) continue;
                // 색상이 다르거나 이미 방문한 경우
                if(color >= 71){
                    if(arr[plusN][plusM] == 'B' || visitColor[plusN][plusM]) continue;
                }else {
                    if(arr[plusN][plusM] == 'R' || arr[plusN][plusM] == 'G' || visitColor[plusN][plusM]) continue;
                }

                visitColor[plusN][plusM] = true;
                queue.add(plusN);
                queue.add(plusM);
            }
        } // Queue END
        if(color == 'R' || color == 'G') cntColor[0]++;
        else cntColor[1]++;
    }
}
