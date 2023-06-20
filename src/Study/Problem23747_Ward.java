package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem23747_Ward {
    static char[][] isekai;
    static char[][] vision;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 세로
        c = Integer.parseInt(st.nextToken()); // 가로

        isekai = new char[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            for(int j = 0; j < c; j++){
                isekai[i][j] = str.charAt(j);
            }
        }
        // System.out.println(Arrays.deepToString(isekai));
        st = new StringTokenizer(br.readLine());
        // 내가 떨어진 좌표 (정점)
        int hr = Integer.parseInt(st.nextToken()) - 1; // 세로
        int hc = Integer.parseInt(st.nextToken()) - 1; // 가로


        String str = br.readLine();
        char[] act = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            act[i] = str.charAt(i);
        }
        vision = new char[r][c]; // 시야 선언
        for (int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                vision[i][j] = '#'; // 초기값 : 다 안보임
            }
        }

        for(int i = 0; i < act.length; i++){
            if(act[i] == 'W' && vision[hr][hc] == '#'){
                ward(hr, hc);
            } else if (act[i] == 'U' && hr > 0) {
                hr = hr - 1;
            } else if (act[i] == 'D' && hr < isekai.length) {
                hr = hr + 1;
            } else if (act[i] == 'L' && hc > 0) {
                hc = hc - 1;
            }else if(act[i] == 'R' && hc < isekai[hr].length){
                hc = hc + 1;
            }
        }
        last(hr, hc);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                sb.append(vision[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 특정 정점이 가리키는 알파벳과 같은 주변 노드 모두 시야 밝히기
    static void ward(int nr, int nc){
        char area = isekai[nr][nc];

        int[] arr1 = {1, -1, 0, 0};
        int[] arr2 = {0, 0, 1, -1};

        Queue<Integer> areaqueue = new LinkedList<>();

        vision[nr][nc] = '.';
        areaqueue.add(nr);
        areaqueue.add(nc);

        while (!areaqueue.isEmpty()){
            nr = areaqueue.poll();
            nc = areaqueue.poll();
            for(int i = 0; i < 4; i++){
                int rr = nr + arr1[i];
                int cc = nc + arr2[i];

                if(rr < 0 || rr >= isekai.length || cc < 0 || cc >= isekai[rr].length) continue;
                if(vision[rr][cc] == '.' || isekai[rr][cc] != area) continue;
                else{
                    vision[rr][cc] = '.';
                    areaqueue.add(rr);
                    areaqueue.add(cc);
                }
            }
        }
    }

    // 마지막 노드의 상하좌우 시야 확보
    static void last(int nr, int nc){
        vision[nr][nc] = '.';
        int[] arr1 = {1, -1, 0, 0};
        int[] arr2 = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++){
            int rr = nr + arr1[i];
            int cc = nc + arr2[i];

            if(rr < 0 || rr >= isekai.length || cc < 0 || cc >= isekai[rr].length) continue;

            vision[rr][cc] = '.';
        }
    }
}