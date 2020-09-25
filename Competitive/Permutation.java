import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void permutations(String consChars, String input, List<String> list) {
        if (input.isEmpty()) {
            list.add(consChars);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            permutations(consChars + input.charAt(i), input.substring(0, i) + input.substring(i + 1), list);
        }
    }

    public static void main(String a[]) {
        List<String> output = new ArrayList<String>();
        permutations("", "123", output);
        for (String c : output) {
            System.out.println(c);
        }
    }
}