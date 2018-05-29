import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Write extends Main implements Main.Command {
    public void execute(){
        File myFile = new File("Information.txt");

        System.out.print("Education: ");
        Scanner in = new Scanner(System.in);
        String name;
        String name_text;
        boolean istrue;
        do {
            name = in.nextLine();
            if(isWord(name)){
                System.out.println("Success!");
                name_text = name;
                istrue = true;
            }
            else {
                System.out.println("You should enter only digits!");
                System.out.println("Please, reenter information!");
                name_text = " ";
                istrue = false;
            }
        }while((!istrue));

        System.out.print("Work experience: ");
        //System.out.println("1 - Male/2 - Female");
        //System.out.print("Enter number: ");
        String gender_text;
        String genderdecision;

        do {
            genderdecision = in.nextLine();
            if(isWord(genderdecision)){
                System.out.println("Success!");
                gender_text = genderdecision;
                istrue = true;
            }
            else {
                System.out.println("You should enter only digits!");
                System.out.println("Please, reenter information!");
                gender_text = " ";
                istrue = false;
            }
        }while((!istrue));

        System.out.print("Your registration number: ");
        String reg,reg_text;
        do {
            reg = in.nextLine();
            if(isNumber(reg)){
                reg_text = reg;
                istrue = true;
            }
            else {
                System.out.println("You should enter only digits!");
                System.out.println("Please, reenter information!");
                reg_text = " ";
                istrue = false;
            }
        }while((!istrue));

        System.out.print("Release date: ");
        String date,date_text;
        do {
            date = in.nextLine();
            if (validDate(date)) {
                System.out.println("Success!");
                date_text = date;
                istrue = true;
            } else {
                System.out.println("Enter date in format DD.MM.YYYY");
                System.out.println("Please, reenter information");
                date_text = " ";
                istrue = false;
            }
        }while(!(istrue));
        //
        System.out.println("**************************************");
        System.out.println("Your registration number - " + reg_text);
        System.out.println("Work experience - " + name_text);
        System.out.println("Education - " + gender_text);
        System.out.println("Release date - " + date_text);
        System.out.println("**************************************");
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
            writer.println("Name - " + name_text);
            writer.println("Gender - " + gender_text);
            writer.println("Registration number - " + reg_text);
            writer.println("Registration date - " + date_text);
            writer.println("**************************************");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isWord(String in){
        return Pattern.matches("[a-zA-Z]+",in);
    }

    public static boolean isNumber(String in){
        return Pattern.matches("[0-9]+",in);
    }

    public static boolean validDate(String in){
        return Pattern.matches("[0-9.,]+",in);
    }
}