import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> orderPQ = new PriorityQueue<>();
            PriorityQueue<Integer> reversePQ = new PriorityQueue<>(Collections.reverseOrder());
            String[] input;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                String command = input[0];
                int num = Integer.parseInt(input[1]);
                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    orderPQ.add(num);
                    reversePQ.add(num);
                } else {
                    if (num == -1 && !orderPQ.isEmpty()) {
                        while (!orderPQ.isEmpty() && map.get(orderPQ.peek()) == 0) {
                            orderPQ.poll();
                        }
                        if (!orderPQ.isEmpty()) {
                            int temp = orderPQ.poll();
                            map.put(temp, map.get(temp) - 1);
                        }

                    } else if (num == 1 && !reversePQ.isEmpty()) {
                        while (!reversePQ.isEmpty() && map.get(reversePQ.peek()) == 0) {
                            reversePQ.poll();
                        }
                        if (!reversePQ.isEmpty()) {
                            int temp = reversePQ.poll();
                            map.put(temp, map.get(temp) - 1);
                        }

                    }
                }
            }

            while (!orderPQ.isEmpty() && map.get(orderPQ.peek()) == 0) {
                orderPQ.poll();
            }


            while (!reversePQ.isEmpty() && map.get(reversePQ.peek()) == 0) {
                reversePQ.poll();
            }

            System.out.println((orderPQ.isEmpty() || reversePQ.isEmpty()) ? "EMPTY" : reversePQ.poll() + " " + orderPQ.poll());
        }
    }
}