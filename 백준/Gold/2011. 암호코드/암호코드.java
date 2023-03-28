import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cryptogram = br.readLine();
        int [][] dp = new int[5001][2];
        boolean check = true;
        dp[0][0] = 1;
        for (int i = 1; i < cryptogram.length(); i++){
            if (cryptogram.charAt(i) == '0' &&
                    (cryptogram.charAt(i-1) == '0' || cryptogram.charAt(i-1) >= '3')) {
                check = false;
                break;
            }
            if (Integer.parseInt(cryptogram.substring(i-1, i+1)) <= 26){
                dp[i][1] = dp[i-1][0];
            }
            if (cryptogram.charAt(i) != '0')
                dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000;
        }
        if (cryptogram.charAt(0) == '0') check = false;
        if (check)
            System.out.println((dp[cryptogram.length()-1][0] + dp[cryptogram.length()-1][1])% 1000000);
        else System.out.println(0);
    }

}