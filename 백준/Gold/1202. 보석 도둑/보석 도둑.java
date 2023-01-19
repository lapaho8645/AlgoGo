import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Item [] Items = new Item[N];
        int [] capacity = new int[K]; // 가방에 들어갈 수 있는 최대 무게, 하나의 가방에는 하나의 보물만
        for(int i = 0; i < N; i++){
            Items[i] = new Item(sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i < K; i++){
            capacity[i] = sc.nextInt();
        }

        Arrays.sort(Items);
        Arrays.sort(capacity);
        int idx = 0;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < K; i++){
            for(int j = idx; j < N; j++){
                if(Items[j].weight > capacity[i]) break;
                pq.add(Items[j].value);
                idx++;
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }

        }
        System.out.println(sum);
    }
    public static class Item implements Comparable<Item>{
        int weight;
        int value;
        public Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
        @Override
        public int compareTo(Item o){
            return this.weight == o.weight ? o.value - this.value : this.weight - o.weight;
        }
    }
}