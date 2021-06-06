// do not remove imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    // define info method here
    public static <T> String info(T[] coll){
        StringBuilder str = new StringBuilder();
        str.append("[");
        int count = 1;
        for (T ag : coll) {
            if (coll.length == count){
                str.append(ag);
            } else {
                str.append(ag).append(", ");
                count++;
            }
        }
        str.append("]");
        return str.toString();
    }
}