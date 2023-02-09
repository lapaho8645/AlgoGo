import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc =1; tc <= T; tc++){
            int n = sc.nextInt();
            boolean [] arr = new boolean [n+1];
            for(int i = 2; i <= n; i++){
                if(arr[i]) continue;
                for(int j = 2; j*i <= n; j++){
                    arr[i*j] = true;
                }
            }
           
            int first = 0;
            int second = 0;
            for(int i = n / 2; i > 1; i--){
                if(!arr[i] && !arr[n-i]){
                    first = i;
                    second = n-i;
                    break;
                }
            }
            System.out.println(first + " " + second);
        }
    }
}