import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int abs = 1;
        int idx = 0;
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '-' || input.charAt(i) == '+') {
                answer = answer + abs * Integer.parseInt(input.substring(idx, i));
                idx = i + 1;
            }
            if(input.charAt(i) == '-'){
                abs = -1;
            }

        }
        answer = answer + abs * Integer.parseInt(input.substring(idx, input.length()));
        System.out.println(answer);

    }
}