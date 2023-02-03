import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] places = new int[n];
        for(int i = 0; i < n; i++){
            places[i] = sc.nextInt();
        }
        Arrays.sort(places);
        System.out.println(places[(n-1)/2]);
    }
}