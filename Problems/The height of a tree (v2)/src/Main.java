import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nodes = new int[len];

        for (int i =0 ; i < len; i++){
            nodes[i] = sc.nextInt();
        }

        int[] depth = new int[nodes.length];

        // fill depth of all nodes
        for (int k = 0; k < nodes.length; k++) {
            fillDepth(nodes, k, depth);
        }

        OptionalInt ht = Arrays.stream(depth).max();
        System.out.println(ht.getAsInt());

    }

    static void fillDepth(int[] parent, int i, int[] depth) {

        // If depth[i] is already filled
        if (depth[i] != 0) {
            return;
        }

        // If node at index i is root
        if (parent[i] == -1) {
            depth[i] = 1;
            return;
        }

        // If depth of parent is not evaluated before, then evaluate
        // depth of parent first
        if (depth[parent[i]] == 0) {
            fillDepth(parent, parent[i], depth);
        }

        // Depth of this node is depth of parent plus 1
        depth[i] = depth[parent[i]] + 1;
    }


}