import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int total;
        Random rand = new Random(a + b);

        total = IntStream.range(0, n).map(i -> rand.nextInt(b - a + 1) + a).sum();

        System.out.println(total);

    }
}