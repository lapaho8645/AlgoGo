import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            String [] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = br.readLine();
            }
            Arrays.sort(input);
            
            boolean check = true;
            for(int i = 0; i < n-1; i++){
                if(input[i].length() > input[i+1].length())
                    continue;
                if(input[i].equals(input[i+1].substring(0, input[i].length()))){
                    check = false;
                    break;
                }
            }
            System.out.println(check ? "YES" : "NO");
        }
    }
}