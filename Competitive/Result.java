import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] parted = input.split(" ");
        Double n1 = Double.parseDouble(parted[0]);
        Double n2 = Double.parseDouble(parted[1]);
        Double l = s.nextDouble();
        Double d = Math.pow(n2 - n1, l);
    }
}