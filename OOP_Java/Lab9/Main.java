package laba9;

import java.util.Scanner;
import laba8.StringSplit;

public class Main {
    public static void main (String[] args) {
        new Main().showMenu();
        Scanner in = new Scanner(System.in);
        Container container = new Container();
        while (true) {
            StringSplit stringSplit = new StringSplit(in.nextLine());
            try {
                switch (stringSplit.getString(0)) {
                    case "add":
                        for (int i = 1; i < stringSplit.getSize(); i++)
                            container.add(stringSplit.getString(i));
                        System.out.println("ok");
                        break;
                    case "show":
                        System.out.println(container.toString());
                        break;
                    case "remove":
                        for (int i = 1; i < stringSplit.getSize(); i++)
                            container.remove(stringSplit.getString(i));
                        System.out.println("ok");
                        break;
                    case "search":
                        int index;
                        for (int i = 1; i < stringSplit.getSize(); i++) {
                            index = container.search(stringSplit.getString(i));
                            if (index != -1)
                                System.out.println(stringSplit.getString(i) + " - found such element with index: " + index);
                            else
                                System.out.println(stringSplit.getString(i) + "not found");
                        }
                        break;
                    case "clear":
                        container.clear();
                        System.out.println("ok");
                        break;
                    case "size":
                        System.out.println(container.size());
                        break;
                    case "sort":
                        container.sort();
                        System.out.println("ok");
                        break;
                    case "save":
                        container.save(container);
                        System.out.println("ok");
                        break;
                    case "load":
                        container = container.load();
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
        System.out.println("\"add string1 string2 ...\"    - to add elements");
        System.out.println("\"remove string1 string2 ...\" - to remove element with specified value");
        System.out.println("\"search string1 string2 ...\" - to search for element with specified value");
        System.out.println("\"show\"                       - to show all elements in container");
        System.out.println("\"clear\"                      - to remove all elements from container");
        System.out.println("\"size\"                       - to show amount of elements in container");
        System.out.println("\"sort\"                       - to sort elements by length");
        System.out.println("\"save\"                       - to save container in data.bin file");
        System.out.println("\"load\"                       - to load from data.bin file");
        System.out.println("\"quit\"                       - to stop program");
    }
}
