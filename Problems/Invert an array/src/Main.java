// do not remove imports
import java.util.*;
import java.util.function.Function;

class ArrayUtils {
    // define invert method here
    public static <T> T[] invert(T[] coll) {
        for (int i = 0; i < coll.length / 2; i++) {
            T temp = coll[i];
            coll[i] = coll[coll.length - 1 - i];
            coll[coll.length - 1 - i] = temp;
        }
        return coll;
    }
}