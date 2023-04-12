import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10808_Alphabet { // 배열 문제 / 문제 번호 10808 알파벳 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳 소문자로 이루어진 단어 S
        String s = br.readLine();

        // S 를 char 문자열로 변환
        // String 클래스의 toCharArray
        char[] sArr = s.toCharArray();

        // 알파벳 원본과 비교해서 순서대로
        // a가 있으면 [0]++, z가 있으면 [25]++ 할 배열
        int[] arr = new int[26];

        // 알파벳 원본 String
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        // 반복문 통해 개수파악
        for(int i=0; i < sArr.length; i++){
            for (int j = 0; j < alphabet.length; j++){
                if(sArr[i] == alphabet[j])
                    arr[j]++;
            }
        }

        for (int i=0; i < alphabet.length; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
