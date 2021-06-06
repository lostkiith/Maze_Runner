import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ListUtils {

    /**
     * It splits the passed list into a sequence of sublists with a predefined size 
     */
    public static <T> List<List<T>> splitListIntoSubLists(List<T> list, int subListSize) {
        List<List<T>> sublists = new ArrayList<>();

        // write your code here
        if (subListSize >= list.size()) {
            sublists.add(list);
            return sublists;
        }
        int count = 0;
        List<T> subList = new ArrayList<>();
        for (T num : list) {
            if (count < subListSize) {
                subList.add(num);
                count++;
            } else if (count == subListSize) {
                sublists.add(subList);
                subList = new ArrayList<>();
                subList.add(num);
                count = 1;
            }

        }
        if (!subList.isEmpty()) {
            sublists.add(subList);
        }

        return sublists;
    }
}

/* Please, do not modify code in this class */
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] values = scanner.nextLine().split("\\s+");

        final List<Integer> list = Arrays.asList(values).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final int subListSize = Integer.parseInt(scanner.nextLine());

        final List<List<Integer>> subLists = ListUtils.splitListIntoSubLists(list, subListSize);

        subLists.forEach(subList -> {
            final String representation = subList.stream().map(Object::toString).collect(Collectors.joining(" "));
            System.out.println(representation);
        });
    }
}