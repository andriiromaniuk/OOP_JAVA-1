import java.io.*;

public class AutoFill extends Main implements Main.Command {
    public void execute(){
        File myFile = new File("C:\\Users\\DareBlig\\IdeaProjects\\Labs\\Lab_12\\Information.txt");
        String name_txt = "no work exp";
        String gender_txt = "middle education";
        String reg_txt = "156689523";
        String date_txt = "21.08.2017";
        System.out.println("Your registration number - " + reg_txt);
        System.out.println("Work experience - " + name_txt);
        System.out.println("Education - " + gender_txt);
        System.out.println("Release date - " + date_txt);
        System.out.println("**************************************");
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
            writer.println("Your registration number - " + reg_txt);
            writer.println("Work experience - " + name_txt);
            writer.println("Education - " + gender_txt);
            writer.println("Release date - " + date_txt);
            writer.println("**************************************");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("File autofilled!");
    }
}