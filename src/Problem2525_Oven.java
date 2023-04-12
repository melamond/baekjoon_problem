import java.util.Scanner;

public class Problem2525_Oven {
    public static void main(String[] args) {
        //2525번 오븐 시계

        // 입력 방식 정하기
        Scanner sc = new Scanner(System.in);

        // 현재 시각 A 시 B 분
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 요리에 걸리는 시간 C 분
        int C = sc.nextInt();

        // B + C 가 60이 되면 시간을 1 추가해줄 카운트
        int overHour = (B + C) / 60;

        // B + C 로 초과한 시간 이후 나머지 분
        int overMin = (B + C) % 60;

        // overHour + A
        int totalHour = A + overHour;

        // 시간은 0~23이기 때문에 24시를 돌면 1이 아닌 0부터 시작하도록 해주자
        if(totalHour >= 24){
            totalHour = A + overHour - 24;
        }

        System.out.print(totalHour+ " "+overMin);
    }
}
