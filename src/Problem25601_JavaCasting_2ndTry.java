import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem25601_JavaCasting_2ndTry {
    public static void main(String[] args) throws IOException {
        // br, st 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // A와 B를 받을 Hashmap 생성
        HashMap<String, String> map = new HashMap<String, String>();

        // A와 B를 받는 st
        st = new StringTokenizer(br.readLine());
        map.put(st.nextToken(), st.nextToken());
    }
}
