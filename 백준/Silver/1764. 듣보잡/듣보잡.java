import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);
        HashSet<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < N ; i++){
            input = br.readLine();
            set.add(input);
        }
        for(int i = 0; i < M; i++){
            input = br.readLine();
            if(set.contains(input)) {
                cnt++;
                list.add(input);
            }
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(cnt);
        System.out.print(sb.toString());
    }
}