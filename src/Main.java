//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static int suma(int[] v) {
        int suma = 0;
        for(var elem : v) {
            suma += elem;
        }
        return suma;
    }
    public static void main(String[] args) {
        int[] v = new int[10];
        Scanner input = new Scanner(System.in);
        for(int i = 1; i <= 5; ++i) {
            v[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(v));
    }
}