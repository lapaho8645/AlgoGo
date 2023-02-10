import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean [] arr = new boolean [1000001];
        arr[0] = arr[1] = true;
        for(int i = 1; i <= 1000000; i = i+2){
            if(arr[i]) continue;
            for(int j = 2; j*i <= 1000000; j++){
                arr[i*j] = true;
            }
        }
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            boolean check = false;
            for(int i = 1; i <= n/2; i=i+2){
                if(!arr[i] && !arr[n-i]){
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
                    check = true;
                    break;
                }
            }
            if(!check){
                sb.append("Goldbach's conjecture is wrong.\n");
            }

        }
        System.out.println(sb.toString());
    }
}