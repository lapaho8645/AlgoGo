import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int [] weights = new int [N+1];
        int [] values = new int [N+1];
        int [][] results = new int [N+1][K+1];
        for(int i = 1; i <= N; i++){
            input = br.readLine().split(" ");
            weights[i] = Integer.parseInt(input[0]);
            values[i] = Integer.parseInt(input[1]);
        }
        for(int item = 1; item <= N; item++){            //물건 i개를 고려했을때
            int itemWeight = weights[item];
            int itemValue = values[item];
            for(int weight = 1; weight<=K;weight++){           //j무게까지
                if(itemWeight <= weight){
                    results[item][weight] = Math.max(results[item-1][weight], itemValue + results[item-1][weight - itemWeight]);
                }else{
                    results[item][weight] = results[item-1][weight];
                }
            }
        }
        System.out.println(results[N][K]);

    }

}