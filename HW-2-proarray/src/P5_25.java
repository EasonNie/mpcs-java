
/**
 * Created by Eason on 10/5/15.
 */
public class P5_25 {

    final static String[] digitStr = {"||:::", ":::||",
            "::|:|", "::||:", ":|::|", ":|:|:",
            ":||::", "|:::|", "|::|:", "|:|::",
    };
    //digitStr[i] is the barCode of digit i
    //E.g. digitStr[0] is "||:::" which represent digit 0
    //     digitStr[1] is ":::||" which represent digit 1
    //      So on....

    public static void main(String[] args) {
        printBarCode(95014);    //Just put your zipCode here.
    }

    public static void printDigit(int d) {
        System.out.print(digitStr[d]);      //Strings for digit i have already been saved in digitStr.
    }   //It will print string for digit d.
        //E.g. If d = 2, it will print:digitStr[2] which is "::|:|".


    public static void printBarCode(int zipCode) {
        System.out.print("|");  //Start bar.

        int[] digits = new int[6];
        int sum = 0;

        for (int i = 4; i >= 0; i--) {
            digits[i] = zipCode % 10;   //Extract the last digit
            zipCode = zipCode / 10;     //Right shift the zipCode
            sum = sum + digits[i];
        }

        digits[5] = 10 - sum % 10;  //Calculate sum

        for (int digit : digits) {  //Print the digit one by one.
            printDigit(digit);
        }

        System.out.print("|");  //End bar.
    }

}
