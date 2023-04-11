
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

// 백준 10828 스택 (실버 4)
public class Problem10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 몇 줄 명령을 입력 받을지 결정하는 N 함수
        String s1 = br.readLine();// N함수를 임시로 입력받을 문자열
        int n = Integer.parseInt(s1); // 문자열을 형변환

        // 사이즈를 정하는 함수 top
        int top = -1; // 배열이 비었을 때 -1 출력

        // 각 명령어 정의
        String push = "push";
        String pop = "pop";
        String size = "size";
        String empty = "empty";
        String top1 = "top";

        // 배열은 크기를 정해주지 않으면 안되므로 가능한 최대값 n지정
        int stack[] = new int[n];
        for(int i = 1; i<=n; i++){
            // 명령어 받기
            String str = br.readLine();
            String[] command = str.split(" ");


            // 명령어 확인
            // 문자열은 "==" 이 아니라 equals 로 비교해야 함
            // "==" 로 비교하면 주소값 비교이므로 진행안됨
            if(push.equals(command[0])){ // push 이면 스택에 정수 저장
                top++;
                stack[top]=Integer.parseInt(command[1]);
            }
            if(pop.equals(command[0])){ // pop 이면 맨 위 출력 또는 없을 경우 -1
                if(top < 0){
                    System.out.println(top);
                }else {
                    System.out.println(stack[top]);
                    top--;
                }
            }
            if(size.equals(command[0])){
                System.out.println(top+1);
            }
            if(empty.equals(command[0])){
                if(top == -1){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }
            if(top1.equals(command[0])){
                if(top < 0){
                    System.out.println(top);
                }else {
                    System.out.println(stack[top]);
                }
            }
        }
    }
}
