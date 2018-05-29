package laba11;
import java.io.File;

public class Delete extends Main implements Main.Command {
    public void execute(){
        File myFile = new File("C:\\Users\\DareBlig\\IdeaProjects\\Lab_11\\Information.txt");
        if(myFile.delete()){
            System.out.println("File was successfully deleted!");
        }
        else
            System.out.println("File wasn`t found!");
    }
}
