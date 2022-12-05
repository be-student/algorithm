/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p12605;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            List<String> inputs = Arrays.asList(sc.nextLine().split(" "));
            Collections.reverse(inputs);

            System.out.printf("Case #%d: ", i + 1);
            System.out.println(String.join(" ", inputs));
        }
    }
}