import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int arrayLen = sc.nextInt();
            int node;
            ArrayList<Integer> nodes = new ArrayList<>(arrayLen);
            while (sc.hasNext()){
                nodes.add(sc.nextInt());
            }
            int treeHeight = 0;
            int currentHeight;
            for (Integer integer : nodes) {
                currentHeight = 1;
                node = integer;
                while (node != -1) {
                    node = nodes.get(node);
                    currentHeight++;
                }
                if (currentHeight > treeHeight) {
                    treeHeight = currentHeight;
                }
            }
            System.out.println(treeHeight);
        }
    }
}