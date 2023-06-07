package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem4963_NumofIsland {
    static int arr[][];
    static boolean visited[][];
    static int w;
    static int h;
    static Queue<Integer> queue = new LinkedList<>();
/*
    static int dfs(int height, int weight){ // 깊이 우선 탐색
        if(height < 0 || weight < 0) return 0;
        if(height > h - 1 || weight > w - 1) return 0;

        if(arr[height][weight] == 1 && !visited[height][weight]) {
            visited[height][weight] = true;
            dfs(height, weight+1); // 오른쪽
            dfs(height-1, weight); // 위쪽
            dfs(height+1, weight); // 아래
            dfs(height, weight-1); // 왼쪽
            dfs(height-1, weight+1); // 대각선 오른쪽 위
            dfs(height+1, weight+1); // 대각선 오른쪽 아래
            dfs(height-1, weight-1); // 대각선 왼쪽 위
            dfs(height+1, weight-1); // 대각선 왼쪽 아래
            return 1;
        }
        else {
            return 0;
        }
    }


 */
    static int bfs(int height, int weight){
        queue.clear();
        if(arr[height][weight] == 1 && !visited[height][weight]){
            queue.add(height);
            queue.add(weight);
            visited[height][weight] = true; 
            // 반드시 Queue에 좌표값을 넣을 때 체크해야함
            // 그렇지 않으면 이미 방문했던 좌표를 여러번 넣는 현상으로 인해 메모리를 많이 잡아먹게 됨 
        } else {
            return 0;
        }
        int hei;
        int wei;
        while (!queue.isEmpty()){ // 위로 가는 bfs
            hei = queue.poll();
            wei = queue.poll();


            int[] idxh = {hei+1, hei, hei-1};
            int[] idxw = {wei+1, wei, wei-1};

            for (int i : idxh){
                for(int k : idxw){
                    if(i > h-1 || k > w-1) continue;
                    else if(i < 0 || k < 0) continue;
                    if(visited[i][k]) continue;
                    if(arr[i][k] == 1) {
                        queue.add(i);
                        queue.add(k);
                        visited[i][k] = true;
                    }
                }
            }
        }
        if(arr[height][weight] == 1) return 1;
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        outer : while (true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 가로 너비
            h = Integer.parseInt(st.nextToken()); // 세로 높이

            if(w == 0 && h == 0) break ; // 0이 들어오면 반복 종료

            arr = new int[h][w]; // 배열 [높이][너비]
            visited = new boolean[h][w]; // 방문 여부

            for(int i = 0; i < h; i++){ // 입력부
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < w; k++){
                    arr[i][k] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            // System.out.println(Arrays.deepToString(arr)); // 출력 확인부
            for(int i = 0; i < h; i++){
                for(int k = 0; k < w; k++){
                    // cnt += dfs(i, k); // dfs의 return 결과를 카운트에 ++

                    if(!visited[i][k]) cnt += bfs(i, k);
                }
            }
            System.out.println(cnt);
        }
    }
}
