import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        //int a = 7;
        //int b = 9;
        //int n = 4;
        //int k = 100;

        HashMap<Integer, Integer> seeds = new HashMap<>();

        for (int i = a; i <= b; i++) {
            Random rand = new Random(i);
            int mix = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int randInt = rand.nextInt(k);
                if (randInt > mix) {
                    mix = randInt;
                }
            }
            seeds.put(i,mix);
        }
        System.out.println(Collections.min(seeds.entrySet(), Map.Entry.comparingByValue()).getKey());
        System.out.println(Collections.min(seeds.entrySet(), Map.Entry.comparingByValue()).getValue());
    }
}