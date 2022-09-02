package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String input [];
        for(int t = 1; t <= T; t++){
            input = br.readLine().split(" ");
            for(int i = 0; i < input.length; i++){
                for(int j = input[i].length() - 1; j >= 0; j--){
                    sb.append(input[i].charAt(j));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
