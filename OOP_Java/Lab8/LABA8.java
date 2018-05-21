import java.util.Scanner;

public class LABA8 {

    public static void main(String[] args) {
        String text;
        text="-h";
        A6 obj=new A6();
        while (text.equals("-h")||text.equals("-d")) {
            text=inScan();
            if(text.equals("-h")||text.equals("-d"))
                obj.print();
        }
        int counter=0;
        String jo="";
        String bukvanaI;
        String mas[]=new String [text.length()];
        for(int i=0;i<text.length();i++) {
            bukvanaI = Character.toString(text.charAt(i));

            if (bukvanaI.equals(" ")) {

                mas[counter] = jo;
                counter++;
                jo = "";
                bukvanaI="";
            }

            jo = jo + bukvanaI;

            if (i == text.length() - 1) {
                mas[counter]=jo;
                counter++;
            }

        }
        int k=0;
        for(int i=0;i<counter;i++) {
            System.out.print(mas[i]+" ");

        }

        String arr[]=new String[counter];

        String arrg[] = new String[counter];
        String arrp[] = new String[counter];
        String other[] = new String[counter];
        int countg = 0;
        int countp = 0;
        int counto = 0;
        int tempg =0;
        int tempp =0;
        int tempo =0;
        int temp =0;
        for(int i=0;i<counter;i++) {
            bukvanaI = Character.toString(mas[i].charAt(0));
            char charnai = mas[i].charAt(0);
            if (bukvanaI.equals("a")||bukvanaI.equals("e")||bukvanaI.equals("y")||bukvanaI.equals("u")||bukvanaI.equals("o")||bukvanaI.equals("i")) {
                arrg[countg] = mas[i];
                tempg = arrg[countg].length();
                countg ++;
            }
            else if (Character.isLetter(charnai)) {
                arrp[countp] = mas[i];
                tempp = arrp[countp].length();
                countp ++;
            }
            else {
                other[counto] = mas[i];
                tempo = other[counto].length();
                counto ++;

            }

        }

        System.out.println();
        System.out.print("Golosni: ");
        for(int i=0;i<countg;i++) {
            System.out.print(""+arrg[i]+"");
        }
        System.out.print("  dovjina: "+tempg+"");
        System.out.println();
        System.out.print("Prugolosni: ");
        for(int i=0;i<countp;i++) {
            System.out.print(""+arrp[i]+" ");
        }
        System.out.print("  dovjina: "+tempp+"");
        System.out.println();
        System.out.print("Other: ");
        for(int i=0;i<counto;i++) {
            System.out.print(" "+other[i]+" ");
        }
        System.out.print("  dovjina: "+tempo+"");
    }



    public static String inScan(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input : ");
        String terra = input.nextLine();
        return terra;
    }

}

interface HTHING {
    public void print();
}
class A6 implements HTHING{
    public void print(){
        System.out.println("THE COMANDS ARE:\n-h for help\n-d for info while program is running \nmade by: Horbliuk Valentin");
    }
}
