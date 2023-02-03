import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long max = 0;
        long [] length = new long[k];
        for(int i = 0 ; i < k; i++){
            length[i] = sc.nextInt();
            max = Math.max(max, length[i]);
        }
        long low = 1;
        long high = max;
        long middle = 0;

        while(low <= high){
            middle = (low + high) / 2;
            long cnt = 0;
            for(int i = 0; i < k; i++){
                cnt += length[i] / middle;
            }
            if(cnt < n){
                high = middle - 1;
            }else{
                low = middle + 1;
            }

        }
        System.out.println(low - 1);
    }
}
