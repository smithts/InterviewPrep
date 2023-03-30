package hackerrank;
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class ExtraLongFactorial {
    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    private static Map<Integer,BigDecimal> visited = new HashMap<>();

    public static void extraLongFactorials(int n) {
        visited.put(1, new BigDecimal(1));
        BigDecimal result = extraLongFactorialsHelper(n);
        System.out.println(result);
        visited.put(n, result);
    }

    public static BigDecimal extraLongFactorialsHelper(int n) {
        // Write your code here
        if (visited.containsKey(n)) {
            return visited.get(n);
        } else {
            BigDecimal current = new BigDecimal(n);
            return current.multiply(extraLongFactorialsHelper(n-1));
        }
    }

}
