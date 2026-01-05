//  ISBN

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();

        int sum = 0;
        int idx = 0;

        for (int i = 0; i < isbn.length(); i++) {
            if (isbn.charAt(i) == '*'){
                idx = i;
                continue;
            }
            if (i%2 == 0){
                sum += Character.getNumericValue(isbn.charAt(i));
            }
            else{
                sum += 3 * Character.getNumericValue(isbn.charAt(i));
            }
        }

        for(int i = 0; i < 10; i++){
            if ((idx % 2 == 0 ? sum + i: sum + 3 * i) % 10 == 0){
                System.out.println(i);
            }
        }
        
    }
}