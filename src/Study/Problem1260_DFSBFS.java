package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1260_DFSBFS {
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken()); // 정점의 개수
        int line = Integer.parseInt(st.nextToken()); // 간선(라인)의 개수
        int start = Integer.parseInt(st.nextToken()); // 탐색 시작 정점번호

        int[][] arr = new int[line][2]; // 숫자 2개씩 line 만큼 입력 받을 배열

        for (int i = 0; i < line; i++) { // 간선의 개수만큼 반복 입력
            st = new StringTokenizer(br.readLine());
            // 0 1과 같은 형식으로 입력받기
            // 무방향 그래프
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작
            arr[i][1] = Integer.parseInt(st.nextToken()); // 도착
        }
        graph = new int[vertex + 1][vertex + 1]; // 그래프 표시할 이차원 배열, 0번 열은 버리는 열
        visited = new boolean[vertex + 1]; // 방문 여부를 표시할 배열

        for (int k = 0; k < line; k++) {
            setGraph(arr[k][0], arr[k][1]);
        }

        dfs(start);
        System.out.println();
        bfs(start);
    }

    static void setGraph(int i, int k) {
        graph[i][k] = 1;
        graph[k][i] = 1;
    }

    static void dfs(int n) {
        visited[n] = true;
        System.out.print(n + " ");

        for (int i = 1; i < graph.length; i++) {
            if (graph[n][i] == 1 && !visited[i]) { // 방문한 노드가 아니라면 반복문을 통해 재귀
                dfs(i);
            }
        }
    }

    static void bfs(int n) {
        visited = new boolean[graph.length]; // 이미 사용한 visited 배열을 초기화
        Queue<Integer> queue = new LinkedList<>(); // 다음으로 가야 할 곳을 표기하기 위한 Queue 선언
        queue.offer(n); // 정점 번호 넣기
        visited[n] = true; // 넣은 정점을 방문했다는 표시

        while (!queue.isEmpty()) { // Queue가 빌 때까지
            int current = queue.poll(); // 현재 탐색중인 노드는 큐에서 꺼낸 수이다
            System.out.print(current + " ");

            for (int i = 1; i < graph.length; i++) { // graph 2차원 배열의 한쪽 길이만큼 반복
                if (graph[current][i] == 1 && !visited[i]) { // 현재 방문중인 graph 배열이 1(간선 있음) 이고, 방문한 적이 없다면
                    queue.offer(i); // Queue에 집어넣고 방문여부 체크
                    visited[i] = true;
                }
            }
        }
    }
}
