import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int searchIndexOfKOccurrence(int[] numbers, int value, int k) {
        // write your code here
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (value == number) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] numbers;
        final int k;
        final int value;
        if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            value = Integer.parseInt(scanner.nextLine());
            k = Integer.parseInt(scanner.nextLine());
        } else {
            numbers = new int[0];
            value = 0;
            k = 1;
        }
        System.out.println(searchIndexOfKOccurrence(numbers, value, k));
    }
}