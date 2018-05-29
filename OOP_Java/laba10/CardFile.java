package laba10;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.Scanner;
import java.io.*;

public class CardFile {
    private int size = 10;
    private int last = 0;
    private User[] users = new User[size];
    private void increaseSize() {
        size = (size * 3) / 2 + 1;
        User[] usersCopy = new User[size];
        System.arraycopy(users, 0, usersCopy, 0, users.length);
        users = usersCopy;
    }
    void add() {
        if (last + 1 < size) {
            Scanner in = new Scanner(System.in);
            users[last] = new User();
            System.out.print("Реєстраційний номер :         ");
            users[last].setFirstName(in.next());
            System.out.print("Досвід роботи :               ");
            users[last].setLastName(in.next());
            System.out.print("Освіта:                       ");
            users[last].setPatronymic(in.next());
            System.out.print("Дата звільнення :             ");
            users[last].setBirthday(in.next());
            System.out.print("Вимоги до майбутньої роботи : ");
            users[last].setEyeColor(in.next());
           /* System.out.print("        : ");
            users[last].setHeight(in.next());
            System.out.print("Specific marks: ");
            in.nextLine();*/
            users[last].setSpecificMarks(in.nextLine());
            last++;
        }
        else increaseSize();
    }
    void clear() {
        size = 10;
        last = 0;
        users = new User[size];
    }

    int size() { return last; }

    void remove(int index) {
        User[] usersCopy = new User[size()];
        System.arraycopy(users, 0, usersCopy, 0, index);
        System.arraycopy(users, index + 1, usersCopy, index, last - index);
        users = usersCopy;
    }
    User getUser(int index) { return users[index]; }

    void encode(CardFile cardFile) {
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream("data.xml")));
            xmlEncoder.writeObject(cardFile);
            xmlEncoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    CardFile decode() {
        CardFile cardFile = new CardFile();
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
                    new FileInputStream("data.xml")));
            cardFile = (CardFile)xmlDecoder.readObject();
            xmlDecoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return cardFile;
    }
}
