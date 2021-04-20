import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class base_converter {
   

       
// function to convert a decimal number to binary
public static String binary_convert(int i) {
    String start = "";
    int num = i;

    // uses division method to calulate the binary number 
    while(num > 0) {
        if(num % 2 == 0) {
            start = start + "0";
            num = num / 2;
        }
        else {
            start = start + "1";
            num = (num - 1) / 2;
        }
    }
    String out = start + Integer.toString(num);
    if(out.length() < 16) {
        for(int j = 16 - out.length(); j > 0; j = j - 1) {
            out = "0" + out;
        }
    }
    return out;
    }

// function to convert decimal to hexadecimal 
public static String hexadecimal_convert(int j){
    int remainder;

    String result = "";

    List<String> hex_chars = Arrays.asList("0","1", "2", "3", "4", "5", "6","7","8","9","A","B","C","D","E","F");

    //uses division method to calculate the hexadecimal 
    while(j>0){
        remainder=j%16;
        result=hex_chars.get(remainder)+result;  // remiander is assigned to a hexadecimal character. 
        j=j/16;
    }

    return result;
   
}
}



    

