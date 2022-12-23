import java.util.Scanner;

public class Main {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int N, A[], add, sub, mul, div;
    static char [] op, selected;
    static char [] operations = {'+', '-', '*', '/'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        op = new char[N-1];
        selected = new char[N-1];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int index = 0;
        int input;
        for(int i = 0; i < 4; i++){
            input = sc.nextInt();
            for(int j = 0; j < input; j++){
                op[index] = operations[i];
                index++;
            }
        }
        recur(0, 0);
        System.out.println(max);
        System.out.println(min);
    }

    public static void recur(int cnt, int flag) {

        if(cnt == N-1){
            int result = getResult();
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        for(int i =0 ; i< N-1; i++){
            if ((flag & 1 << i) != 0) continue;
            selected[cnt] = op[i];
            recur(cnt+1, flag | 1 << i);
        }

    }
    public static int getResult (){
        int result = A[0];
        for(int i = 0; i < N - 1; i++){
            switch (selected[i]){
                case '+':
                    result = result + A[i+1];
                    break;
                case '-' :
                    result = result - A[i+1];
                    break;
                case '*' :
                    result = result * A[i+1];
                    break;
                case '/' :
                    result = result / A[i+1];
                    break;
            }
        }
        return result;
    }
}