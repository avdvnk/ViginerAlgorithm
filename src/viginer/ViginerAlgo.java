package viginer;

import java.io.*;

public class ViginerAlgo {
    private String key;
    public void viginer (String input, String output){
        try{
            char symbol;
            key = new KeyGenerate().getKey();
            System.out.println("Your key: " + key);
            FileOutputStream fos = new FileOutputStream(output);
            FileInputStream fis = new FileInputStream(input);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            StringBuilder sb = new StringBuilder();
            int read = br.read();
            int i = 0;
            while (read != -1){
                symbol = (char)read;
                symbol = mod(symbol, key.charAt(getIdx(i)));
                sb.append(symbol);
                read = br.read();
                i++;
            }
            bw.write(sb.toString());
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void recoverMessage (String input, String output){
        try{
            char symbol;
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            StringBuilder sb = new StringBuilder();
            int read = br.read();
            int i = 0;
            while (read != -1){
                symbol = (char)read;
                symbol = unmod(symbol, key.charAt(getIdx(i)));
                sb.append(symbol);
                read = br.read();
                i++;
            }
            bw.write(sb.toString());
            bw.flush();
        }catch (IOException e){
            e.getMessage();
        }
    }
    private int getIdx (int idx){
        while (key.length() <= idx){
            idx -= key.length();
        }
        return idx;
    }
    private char mod (char a, char b){
        char result = (char)(a + b);
        while (result > 256){
            result -= 256;
        }
        return result;
    }
    private char unmod (char a, char b){
        char result;
        if (a - b < 0){
            result = (char)(256 + a - b);
        }
        else{
            result = (char)(a - b);
        }
        return result;
    }
}
