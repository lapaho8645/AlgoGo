import java.util.Scanner;

public class Main {
    static int A, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        int B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(recur(B));
    }
    public static long recur(int num){
        if(num == 1) return A % C;

        if(num % 2 == 0){
            long cur = recur(num / 2) % C;
            return (cur * cur) % C;
        }else {
            long cur = recur(num / 2) % C;
            return (((cur * cur) % C) * A) % C;
        }
    }
}