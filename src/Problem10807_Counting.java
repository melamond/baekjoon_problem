import java.util.Scanner;

// 백준 10807번 개수 세기 (브론즈 5)

public class Problem10807_Counting {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 개수를 정하는 정수 n
        int n = Integer.parseInt(sc.nextLine());

        // 숫자들을 공백단위로 문자열로 받을 str과
        // split을 통해 숫자를 저장할 "문자형" 배열 arr

        String str = sc.nextLine();
        String[] arr = str.split(" ");

        // 찾아야 할 정수 V
        String v = sc.nextLine();

        // 갯수를 세는 정수 count
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(v.equals(arr[i])){
                count++;
            }
        }
        System.out.println(count);
    }
}
