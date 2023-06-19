package Study;

// 토마토 7576
// 가로 세로 너비우선 탐색


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7576_Tomato {
    static int[][] tomato; // 토마토 그래프
    static boolean[][] visited;
    static int cnt; // 자랄수 있는 땅의 개수
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();

        tomato = new int[n][m];
        /** 입력부 **/
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                /*
                if(tomato[i][j] == 1){ // 익은 토마토
                    // 정점 추가
                    queue.add(i);
                    queue.add(j);
                }
                if(tomato[i][j] == 0){
                    cnt++; // 땅 갯수
                }

                 */
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomato[i][j] == 0){
                    cnt++;
                }
                if(tomato[i][j] == 1){
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        visited = new boolean[n][m];
        /** 탐색부 **/

        System.out.println(bfs(n, m));
        // System.out.println(Arrays.deepToString(tomato));
    }
    /** 너비 우선 탐색 **/
    static int bfs(int n, int m){

        // 상, 하 , 좌, 우
        int[] arrI = {0, 0, -1, 1};
        int[] arrJ = {1, -1, 0, 0};
        int day = 0; // 모두 익는데 걸리는 날짜
        int count = 0; // 익게 한 토마토 갯수

        Queue<Integer> next = new LinkedList<>();
        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            // if(tomato[x][y] == 1) continue;
            visited[x][y] = true;


            for(int i = 0; i < 4; i++){
                int newX = x + arrI[i];
                int newY = y + arrJ[i];

                if(newX < 0 || newY < 0 || newX >= n || newY >= m) continue;

                if(!visited[newX][newY] && tomato[newX][newY] == 0){
                    next.add(newX);
                    next.add(newY);
                    tomato[newX][newY] = 1;
                    count++;
                }
            }


            if(queue.isEmpty()){
                if(next.isEmpty()) continue;
                while (!next.isEmpty()) {
                    queue.add(next.poll());
                }
                day++;
            }
        }
        if(cnt == count) return day;
        else return -1;
    }
}
