import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        PriorityQueue<Comp> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            if(num == 0){
                if(!queue.isEmpty()) {
                    Comp cur = queue.poll();
                    sb.append(cur.positive == 1 ? cur.value : -cur.value).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else {
                queue.add(new Comp(Math.abs(num), num > 0 ? 1 : 0));
            }
        }
        System.out.println(sb.toString());
    }
    public static class Comp implements Comparable<Comp>{
        int value;
        int positive; // 1이 양수, 0이 음수
        Comp(int value, int positive){
            this.value = value;
            this.positive = positive;
        }
        @Override
        public int compareTo(Comp o){
            return this.value == o.value ? this.positive - o.positive : this.value - o.value;
        }
    }
}