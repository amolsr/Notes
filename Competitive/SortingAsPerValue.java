import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SortingAsPerValue {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        TreeSet<Map.Entry<String, String>> set = new TreeSet<>(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return -1;
                } else {
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            if (firstName.matches("[a-z]+") && emailID.matches("[a-z@.]+") && firstName.length() <= 20
                    && emailID.length() <= 50 && emailID.endsWith("@gmail.com")) {
                set.add(new AbstractMap.SimpleEntry<>(emailID, firstName));
            }
        }
        Iterator i = set.iterator();
        while (i.hasNext()) {
            AbstractMap.SimpleEntry<String, String> s = (AbstractMap.SimpleEntry<String, String>) i.next();
            System.out.println(s.getValue());
        }
        scanner.close();
    }
}
