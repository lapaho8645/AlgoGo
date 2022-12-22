import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;
        int [] input = new int [N];
        for(int i = 0; i < N; i++){
            input[i] = sc.nextInt();
        }
        int index = N - 1;
        while(index >= 0 && K > 0){
            cnt += K / input[index];
            K = K % input[index];
            index--;
        }
        System.out.println(cnt);
    }
}