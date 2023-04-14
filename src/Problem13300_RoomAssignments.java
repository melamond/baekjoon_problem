import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13300_RoomAssignments {
    public static void main(String[] args) throws IOException {
        // 문제 13300 방배정, 브론즈 2
        // 1~6학년 , 남녀를 같은 학년의 같은 성별끼리 방배정 해주는 배열문제
        // 참가 학생수, 한 방에 들어가는 최대 인원수 고려 필요

        // br, st
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 총 학생 수 n
        // 한 방 최대 정원 k
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int roomCount = 0;
        int[] manRoom = {0,0,0,0,0,0};
        int[] womenRoom = {0,0,0,0,0,0};

        int sex = -1;
        int grade = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            sex = Integer.parseInt(st.nextToken());
            grade = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= 6; j++){
                if(j == grade && sex == 0){
                    if (manRoom[j-1] < 1)
                        roomCount++;
                    manRoom[j-1]++;
                } else if (j == grade && sex == 1) {
                    if (womenRoom[j-1] < 1)
                        roomCount++;
                    womenRoom[j-1]++;
                }

                if(manRoom[j-1]>k){
                    manRoom[j-1]-=k;
                    roomCount++;
                }
                if (womenRoom[j-1]>k){
                    womenRoom[j-1]-=k;
                    roomCount++;
                }
            }
        }

        System.out.print(roomCount);
    }
}
