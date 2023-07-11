package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Project2606_Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pc = Integer.parseInt(br.readLine()); // 컴퓨터의 갯수

        int t = Integer.parseInt(br.readLine()); // 연결선 갯수

        ArrayList<Integer>[] lists = new ArrayList[pc+1]; // 그래프

        for (int i = 1; i <= pc; i++) { // 그래프 하위 생성
            lists[i] = new ArrayList<Integer>();
        }

        // 예를 들어 1, 2가 연결되었으면
        // 인접 리스트의 list[1]과 list[2]에 각각 하위 리스트가 하나씩 생성되고
        // 그 하위 리스트에 각각 2와 1이 들어가면서 서로 연결됨을 표시함

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());

            lists[arr[0]].add(arr[1]);
            lists[arr[1]].add(arr[0]);
        }


        // 출력 확인
        /*
        for(int i = 1; i <= pc; i++){
            for(int j = 0; j < lists[i].size(); j++){
                System.out.print(lists[i].get(j)+" ");
            }
            System.out.println();
        }
         */

        // 위 코드는 BFS 를 통해 구현되지만
        // 결국 바이러스에 감염된 순서가 아닌, 바이러스에 최종적으로 감염된 총 대수가 중요하므로
        // DFS 를 사용하더라도 상관없다

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[pc+1]; // 방문 여부

        queue.addAll(lists[1]);
        visit[1] = true;

        int cnt = 0; // 감염된 갯수
        while (!queue.isEmpty()){
            int idx = queue.poll();

            if(!visit[idx]){ // 방문하지 않았다면
                visit[idx] = true;
                cnt++;
                queue.addAll(lists[idx]);
            }
        }

        System.out.print(cnt);
    }
}