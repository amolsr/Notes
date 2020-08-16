import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static List<String> getPermutations(String input) {

        List<String> strList = new ArrayList<String>();
        permutations("", input, strList);
        return strList;
    }

    public static void permutations(String consChars, String input, List<String> list) {

        if (input.isEmpty()) {
            list.add(consChars + input);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            permutations(consChars + input.charAt(i), input.substring(0, i) + input.substring(i + 1), list);
        }
    }

    public static void main(String a[]) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        List<String> output = getPermutations("1600");
        for (Object c : output) {
            intList.add(Integer.parseInt(c.toString()));
        }
        for (Integer string : intList) {
            System.out.println(string);
        }
        for (Integer c : intList) {
            if (c % 8 == 0) {
                System.out.println("Yes");
                return;
            }
        }
    }
}