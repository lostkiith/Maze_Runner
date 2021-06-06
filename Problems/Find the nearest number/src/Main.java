import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        List<Integer> clostest = new ArrayList<>();
        List<Integer> found = new ArrayList<>();
        int size = list.size() - 1;
        int n = list.remove(size);
        ArrayList<Integer> largestVal = new ArrayList<>();
        for (int num : list) {
            if (largestVal.isEmpty())
            {
                largestVal.add(num);
            } else if (largestVal.get(0) < num) {
                largestVal.clear();
                largestVal.add(num);
            }else if (largestVal.get(0) == num){
                largestVal.add(num);
            }

            if (num == n) {
                found.add(num);
            } else if (num == n+1 || num == n-1){
                clostest.add(num);
            }
        }
        if (!found.isEmpty()) {
            found.stream().mapToInt(num -> num).mapToObj(num -> num + " ").forEach(System.out::print);
        } else if (clostest.isEmpty()){
            clostest.addAll(largestVal);
            Collections.sort(clostest);
            clostest.stream().mapToInt(num -> num).mapToObj(num -> num + " ").forEach(System.out::print);
        } else {
            Collections.sort(clostest);
            clostest.stream().mapToInt(num -> num).mapToObj(num -> num + " ").forEach(System.out::print);
        }
    }
}