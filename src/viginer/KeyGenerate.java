package viginer;

import java.util.Random;
import java.util.Scanner;

public class KeyGenerate {
    private String key;
    public String getKey() {
        try{
            System.out.println("Generate key(0) / write key(1)");
            Scanner sc = new Scanner(System.in);
            int tmp = sc.nextInt();
            if (tmp == 0){
                System.out.print("Write key length: ");
                sc = new Scanner(System.in);
                int len = sc.nextInt();
                StringBuilder sb = new StringBuilder();
                Random r = new Random();
                for (int i = 0; i < len; i++) {
                    sb.append((char)(r.nextInt(255)));
                }
                key = sb.toString();
                return key;
            }
            if (tmp == 1){
                System.out.print("Write key: ");
                sc = new Scanner(System.in);
                key = sc.nextLine();
                return key;
            }
            else throw new RuntimeException("Incorrect input data!");
        }catch (RuntimeException e){
            e.getMessage();
        }
        return key;
    }
}
