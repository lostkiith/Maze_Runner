// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    // define getFirst method here
    public static <T> T getFirst(T[] coll) {
        return coll.length == 0 ? null : coll[0];
    }
}
