/*
Read strings from console. Write those strings in a file. Stop when input string is 'exit';
Input (example)
> I love
> ITeahome
> courses.
> exit
Output -> console2file.txt
I love ITeahome courses.
 */

package ro.iteahome.consoleToFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        String content = "";
        Scanner inputScanner = new Scanner(System.in);  //scanner pentru input
        System.out.println("Introduceti textul (introducand exit veti termina executia aplicatiei): ");
        String input = inputScanner.nextLine();
        while (!input.matches("exit")){
            content = content + input + " ";
            input = inputScanner.nextLine();
        }
        System.out.println("Ati introdus urmatorul text (il regasiti si in console2file.txt): \n" + content);

        try (FileWriter writer = new FileWriter("console2file.txt");
             BufferedWriter bw = new BufferedWriter(writer)) {
             bw.write(content);
             
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }
}
