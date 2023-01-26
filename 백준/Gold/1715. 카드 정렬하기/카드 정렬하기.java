import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(sc.nextInt());
        }
        int sum = 0;
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                break;
            }
            int tmp = pq.poll() + pq.poll();
            sum += tmp;
            pq.add(tmp);
        }
        System.out.println(sum);
    }
}