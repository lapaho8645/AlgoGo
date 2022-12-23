import java.util.Scanner;

public class Main {
    static int N, col[], cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int [N+1];
        back(1);
        System.out.println(cnt);
    }
    public static void back(int rowNo){
        if(!isAvailable(rowNo - 1)) return;

        if(rowNo > N){
            cnt++;
            return;
        }
        for(int i = 1; i <= N; i++){
            col[rowNo] = i;
            back(rowNo + 1);
        }
    }
    public static boolean isAvailable(int rowNo){
        for(int i = 1; i < rowNo; i++){
            if(col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i])) return false;
        }
        return true;
    }
}