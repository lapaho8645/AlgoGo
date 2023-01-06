import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K)
                break;
            if (cur > 0 && cur * 2 <= 100000 && arr[cur * 2] == 0) {
                arr[cur * 2] = arr[cur] + 1;
                queue.add(cur * 2);
            }
            if (cur - 1 >= 0 && arr[cur - 1] == 0) {
                arr[cur - 1] = arr[cur] + 1;
                queue.add(cur - 1);
            }
            if (cur + 1 <= 100000 && arr[cur + 1] == 0) {
                arr[cur + 1] = arr[cur] + 1;
                queue.add(cur + 1);
            }
            if (cur - 1 == K || cur + 1 == K || cur * 2 == K)
                break;
        }
        System.out.println(arr[K]);
    }
}
// K로 가는 방식이 K/2 * 2로 가던가 K-1 + 1로 가던가 K+1 -1로 가던가