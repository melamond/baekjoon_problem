import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1475_RoomNumber {
    // 백준 문제 1475 방 번호, 실버 5 (배열 문제)
    // 방 번호에 맞는 플레이트를 제작하기
    // 숫자 플레이트 세트는 0~9까지가 1세트이다
    // 방번호 N이 주어지면, N을 만들기 위해 몇세트가 필요한지
    // 참고 : 6이랑 9는 서로 대체 가능

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N을 오름차순해서 하나의 수가 여러 번 나왔을 때, 가장 많이 나온 수의 횟수가 필요한 플레이트의 수
        // ex ) 11222호면 11 / 222 이므로 2가 3개 필요하니 플레이트도 3세트 필요함
        // 오름차순해서 0~9까지의 숫자 개수 세줄 배열 하나 만들고 ++ 해서 가장 높은 수 하나만 출력하면될듯.
        // 6과 9 는 대체 가능하므로 6+9 를 어떻게 구현할지

        String n = br.readLine();
        char[] nArr = n.toCharArray();
        Arrays.sort(nArr); // 오름차순 정렬

        /* 오름차순 되는지 확인용
        for (int i = 0; i < nArr.length; i++)
            System.out.println(nArr[i]);
        */
        int[] countArr = new int[9];
        for (int i = 0; i < nArr.length; i++){
            if(nArr[i] == '0'){
                countArr[0]++;
            } else if (nArr[i] == '1') {
                countArr[1]++;
            } else if (nArr[i] == '2') {
                countArr[2]++;
            } else if (nArr[i] == '3') {
                countArr[3]++;
            } else if (nArr[i] == '4') {
                countArr[4]++;
            } else if (nArr[i] == '5') {
                countArr[5]++;
            } else if (nArr[i] == '6'||nArr[i] == '9') {
                countArr[6]++;
            } else if (nArr[i] == '7') {
                countArr[7]++;
            } else if (nArr[i] == '8') {
                countArr[8]++;
            }
        }
        if (countArr[6] >= 2){ // 6과 9가 합쳐서 2개 이상일 때
            if(countArr[6]%2 > 0){ // 그 개수가 홀수 이면
                countArr[6] = countArr[6]/2 + 1;
            }else {
                countArr[6] = countArr[6]/2;
            }
        }
        Arrays.sort(countArr);
        System.out.print(countArr[8]);
    }
}
