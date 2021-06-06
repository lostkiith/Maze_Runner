import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>(Integer.parseInt(sc.next()));
        Deque<Integer> stackTrack = new ArrayDeque<>();
        String order;
        while (sc.hasNext()){
            order = sc.next();
            if (order.contains("push")) {
                int pushNumber = sc.nextInt();
                stack.addFirst(pushNumber);
                if (stackTrack.isEmpty() || (stackTrack.peekFirst() <= pushNumber)) {
                    stackTrack.addFirst(pushNumber);
                }
            } else if (order.contains("max")) {
                System.out.println(stackTrack.peekFirst());
            } else if (order.contains("pop")) {
                if (Objects.equals(stack.peekFirst(), stackTrack.peekFirst())){
                    stack.pollFirst();
                    stackTrack.pollFirst();
                } else {
                    stack.pollFirst();
                }
            }
        }
    }
}