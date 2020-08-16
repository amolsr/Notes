import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Something {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        String[] parted = input.split(" ");
        Integer n1 = Integer.parseInt(parted[0]);
        Integer n2 = Integer.parseInt(parted[1]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        int count = 0;
        for (int i = n1; i <= n2; i++) {
            for (int j = 0; j <= 2; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l < 6; l++) {
                        String str = String.valueOf(i) + String.valueOf(j) + String.valueOf(k) + String.valueOf(l)
                                + String.valueOf(k) + String.valueOf(j) + String.valueOf(i);
                        try {
                            LocalTime time = LocalTime.parse(str.substring(1), formatter);
                            count++;
                        } catch (Exception e) {
                            // System.out.println(str);
                        }
                    }
                }
            }
        }
        System.out.print(count);
    }
}