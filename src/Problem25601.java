import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 25601번
public class Problem25601 {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 받을 클래스의 수 N
        int n = Integer.parseInt(st.nextToken());


        // 이차원 배열 정의
        String[][] arr = new String[n][n];

        // 행 열
        int x = 0;
        int y = 0;

        // for문으로 클래스 수만큼 받기
        // 마지막에는 상속 여부 판단 필요하므로 n-1만큼 받기

        for(int i = 0; i < n-1 ; i++){
            // 자식 클래스, 부모 클래스 순으로 입력받기
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken(); // A (자식)
            String parent = st.nextToken(); // B (부모)
            
            // 가로 세로로 배열 넣어주기
            // arr[가로][0] / arr[0][세로]
            // if 문을 통해 이미 들어간 문자열 있는지 체크

            if(arr[0][0] == null){ // 만약 [0][0]이 비어있다면 B를 모든 트리의 부모로 설정
                y++; // y = 1;
                arr[0][0]=parent; // [0][0] 은 B
                arr[0][y]=child; // [0][1] 은 A
                continue;
            }

            if(arr[x][0].equals(parent)){ // 만약 [x][0] 이 부모라면 [x++][0]에 자식을 넣기
                x++;
                arr[x][0] = child; //[x+1][0]은 B
                continue;
            } else if (arr[0][y].equals(parent)) { // 만약 [0][y] 가 부모라면 [0][y++]에 자식을 넣기
                y++;
                arr[0][y] = child;
                continue;
            }
        }
        // 마지막 상속관계인지 찾기
        st = new StringTokenizer(br.readLine());
        String class1 = st.nextToken(); // 1번값
        String class2 = st.nextToken(); // 2번값
        int result = -1; // 결과값 (상속관계면 1, 아니면 0)
        outer : for(int i = x; i >= 0; i--){ // 가로축 서칭
            for(int j = y; j >= 0; j--){ // 세로축 서칭
                if(arr[0][0].equals(class1)) { // 1번값이 [0][0]이면 반드시 형변환 가능
                    result = 1;
                    break outer;
                } else if (arr[i][0].equals(class1) && arr[0][j].equals(class2)) { // 1번값이 x축에 있으면서 2번값이 y축에 있으면 형변환 불가
                    result = 0;
                    break outer;
                } else if (arr[i][0].equals(class2) && arr[0][j].equals(class1)) {
                    result = 0;
                    break outer;
                } else {
                    result = 1;
                    break outer;
                }
            }
        }
        System.out.print(result);
    }
}
