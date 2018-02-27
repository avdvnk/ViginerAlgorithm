import viginer.ViginerAlgo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ViginerAlgo vg = new ViginerAlgo();
        System.out.print("Write input filename: ");
        Scanner sc = new Scanner(System.in);
        sc.next();
        System.out.print("Write output filename: ");
        sc = new Scanner(System.in);
        sc.next();
        vg.viginer("input.txt", "output1.txt");
        vg.recoverMessage("output1.txt", "output2.txt");
    }
}
