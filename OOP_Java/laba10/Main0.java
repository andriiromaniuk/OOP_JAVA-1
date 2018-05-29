package laba10;

import java.util.Scanner;

public class Main0 {
    public static void main (String[] args) {
        new Main0().showMenu();
        CardFile cardFile = new CardFile();
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                switch (in.next()) {
                    case "add":
                        cardFile.add();
                        System.out.println("ok");
                        break;
                    case "show":
                        if (cardFile.size() == 0)
                            System.out.println("Card file is empty");
                        else
                            for (int i = 0; i < cardFile.size(); i++)
                                System.out.println(cardFile.getUser(i).toString());
                        break;
                    case "remove":
                        cardFile.remove(in.nextInt());
                        System.out.println("ok");
                        break;
                    case "clear":
                        cardFile.clear();
                        System.out.println("ok");
                        break;
                    case "save":
                        cardFile.encode(cardFile);
                        System.out.println("ok");
                        break;
                    case "load":
                        cardFile = cardFile.decode();
                        System.out.println("ok");
                        break;
                    case "quit":
                        return;
                    default:
                        System.out.println("Wrong command!");
                        break;
                }
            } catch (Exception ignored) {
            }
        }
    }

    private void showMenu() {
        System.out.println("\"add\"            - to add user");
        System.out.println("\"remove <index>\" - to remove user with specified index");
        System.out.println("\"show\"           - to show data about all users");
        System.out.println("\"clear\"          - to clear all data in card file");
        System.out.println("\"save\"           - to save card file in data.xml file");
        System.out.println("\"load\"           - to load card file from data.xml file");
    }
}
