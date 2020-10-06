import java.util.*;
import java.util.stream.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        try {
            Integer test = s.nextInt();
            for (int i = 0; i < test; i++) {
                int n = s.nextInt();
                int[] a = IntStream.range(1, n).toArray();
                List<Integer> arr = Arrays.stream(a).boxed().collect(Collectors.toList());
                List<List<Integer>> perm = listPermutations(arr);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
    }

    public static List<List<Integer>> listPermutations(List<Integer> list) {

        if (list.size() == 0) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<List<Integer>> returnMe = new ArrayList<List<Integer>>();

        Integer firstElement = list.remove(0);

        List<List<Integer>> recursiveReturn = listPermutations(list);
        for (List<Integer> li : recursiveReturn) {

            for (int index = 0; index <= li.size(); index++) {
                List<Integer> temp = new ArrayList<Integer>(li);
                temp.add(index, firstElement);
                returnMe.add(temp);
            }

        }
        return returnMe;
    }
}