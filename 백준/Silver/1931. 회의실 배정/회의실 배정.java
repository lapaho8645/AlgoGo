import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] input;
        List<meeting> list = new LinkedList<>();
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            list.add(new meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        int answer = 1;
        list = list.stream().sorted(meeting::compareTo)
                .collect(Collectors.toList());

        int endTime = list.get(0).end;
        int startTime = list.get(0).start;
        for(int i = 1; i < N ; i++) {

            if(list.get(i).start >= endTime ) {
                answer++;
                endTime = list.get(i).end;
            }else if(list.get(i).end <= startTime){
                answer++;
                startTime = list.get(i).start;
                System.out.println(list.get(i).start + " : " +list.get(i).end);
            }
        }

        System.out.println(answer);
    }
    public static class meeting implements Comparable<meeting>{
        int start, end;
        meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(meeting o) {
            return o.end == this.end ? this.start - o.start : this.end - o.end;
        }
    }
}