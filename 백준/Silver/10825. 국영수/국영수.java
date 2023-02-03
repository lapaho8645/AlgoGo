import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            String name = input[0];
            int korean = Integer.parseInt(input[1]);
            int english = Integer.parseInt(input[2]);
            int math = Integer.parseInt(input[3]);
            pq.add(new Student(name, korean, english, math));
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll().name);
        }
    }

    public static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;
        Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        @Override
        public int compareTo(Student o) {
            return (this.korean == o.korean ?
                        (this.english == o.english ?
                                (this.math == o.math ? this.name.compareTo(o.name) : o.math - this.math)
                        : this.english - o.english)
                    : o.korean - this.korean);
        }
    }
}