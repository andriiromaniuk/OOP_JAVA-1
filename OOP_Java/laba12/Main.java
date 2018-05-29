import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Main {

    public interface Command {
        public void execute();
    }

    public static void main(String[] args) throws FileNotFoundException
    {

        if (args.length < 1 || args.length > 2 && !args[0].equalsIgnoreCase("start")) {
            System.out.println("Good day! Select number:");
            System.out.println("1 - Write to File;");
            System.out.println("2 - Scan File;");
            System.out.println("3 - Autofill File;");
            System.out.println("4 - Erase Data from File;");
            System.out.println("5 - Delete File.");
            System.out.print("Enter number: ");
            Scanner in = new Scanner(System.in);
            int numb = in.nextInt();
            if (numb == 1) {
                Write w = new Write();
                w.execute();
            }
            else if (numb == 2) {
                File file = new File("Information.txt");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
            else if (numb == 3) {
                AutoFill a = new AutoFill();
                a.execute();
            }
            else if (numb == 4) {
                File myFile = new File("Information.txt");
                PrintWriter writer = new PrintWriter(myFile);
                writer.print("");
                writer.close();
                System.out.println("Data from File successfully erased");
            }
            else if (numb == 5) {
                Delete d = new Delete();
                d.execute();
            }
            else if (numb == 6){

            }
            else
                System.out.println("This command is unsupported");
        }
        else if (args[0].equalsIgnoreCase("auto") || args[0].equalsIgnoreCase("-a")) {
            AutoFill a = new AutoFill();
            a.execute();
        }
        else if (args[0].equalsIgnoreCase("write") || args[0].equalsIgnoreCase("-w")) {
            Write w = new Write();
            w.execute();
        }
        else if (args[0].equalsIgnoreCase("scan") || args[0].equalsIgnoreCase("-s")) {
            File file = new File("Information.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
        else if (args[0].equalsIgnoreCase("erase") || args[0].equalsIgnoreCase("-e")) {
            File myFile = new File("Information.txt");
            PrintWriter writer = new PrintWriter(myFile);
            writer.print("");
            writer.close();
            System.out.println("Data from File successfully erased");
        }
        else if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("-d")) {
            Delete d = new Delete();
            d.execute();
        }
        else
            System.out.println("This command is unsupported");
    }
}