import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            Long n = Long.parseLong(nk[0]);
            Long k = Long.parseLong(nk[1]);
            Long smallestInRange = 0l;
            main: for(int i = 0; i < n ; i++){
                for(int j = 0; j < n ; j++){
                    if(i!=j && (i&j)<k && (i&j)>smallestInRange){
                        smallestInRange=Long.parseLong(String.valueOf(i&j));
                        if((smallestInRange-k)==1){
                            break main;
                        }
                    }
                }
            }
            // for(Integer[] p: a){
            //     System.out.println(Arrays.toString(p));
            // }
            System.out.println(smallestInRange);
        }

        scanner.close();
    }
}
