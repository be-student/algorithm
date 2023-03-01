package algorithm.test;

public class Main {

    public static void main(String[] args) {
        int i = 2_100_000_000;
        int j = -2_100_000_000;
        System.out.println(i + (i - j) / 2);
    }
}