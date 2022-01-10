package pl.sda.StringiHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZadaniaStringi {

    public static void main(String[] args) {


        String testowy = "Wczytaj od użytkownika jedną linię tekstu i przypisz ją do zmiennej text a następnie " +
                "wczytaj od użytkownika słowo i przypisz je do zmiennej searched. Następnie " +
                "przeszukaj tekst w poszukiwaniu słowa przypisanego do zmiennej searched.";

        String testowy2 = "Ala lubi koty, ale Ala nie jest    przez koty lubiana. Ola lubi psy.";
        String testowy5 = "xyzala lubi koty ale ala nie jest przez koty lubiana ola lubi psy";

        String testowy3 = " Mój nowy string z białym znakiem na końcu i początku    ";
        String testowy4 = " Mój najnowszy  string z białym znakiem na Końcu i początku   i liczbami 1,2,123,34,56,8,4       i napisem   ";

        String nawiasy1 = "2 * (3.4 - (-7)/2)*(a-2)/(b-1)))";
        String nawiasy2 = "(2 * (3.4 - (-7)/2)*(a-2)/(b-1))";
        String nawiasy3 = "37*63+3)(2 * (3.4 - (-7)/2)*(a-2)/(b-1))(*9+2(";

        String regexDwucyfroweLiczby = "[0-9]{2,}";
        String regexSamogloski = "[oauiyąeęó]";
        String regexWyrazDuzejLitery = "[A-Z][a-zóńąęłżźć]+";
        String regexKoniecTextu = ".$";

        String liczba = "1234567890";


        //StringHelp text = new StringHelp(testowy);

        //text.wypiszStatystykeTextuLitery();

        //text.wypiszStatystykeTextuWyrazyV1();

        //text.wypiszStatystykeTextuWyrazyV2();

        //StringHelp stringLiczba = new StringHelp(liczba);

        //stringLiczba.policzElementyStringa();

        //zlacz(testowy3,testowy4);
        //usunWgRegex(testowy3,regexSamogloski," ");
        //usunWgRegex(testowy4,regexDwucyfroweLiczby," ");
        //usunWgRegex(testowy4,regexWyrazDuzejLitery,"???");
        //usunWgRegex(testowy4,regexKoniecTextu,testowy4.charAt(testowy4.length()-1) + "\n");
        //odwrocStringa(testowy2);
        //sprawdzNawiasy(nawiasy3);
        //szyfrCezara(testowy5, 2);

        //oneTwo("1234567890");

        changeXY("xhixhxihihhhih");

    }

    public static boolean xyzMiddle(String str) {
        int polowa = str.length() / 2;
        int nieparzysty = str.length() % 2;

        if (str.length() >= 3) {
            if (nieparzysty != 0) {
                if (str.charAt(polowa) == 'y' && str.charAt(polowa - 1) == 'x' && str.charAt(polowa + 1) == 'z')
                    return true;
                else return false;
            } else if ((str.charAt(polowa - 1) == 'y' && str.charAt(polowa - 2) == 'x' && str.charAt(polowa) == 'z')
                    || (str.charAt(polowa + 1) == 'z' && str.charAt(polowa - 1) == 'x' && str.charAt(polowa) == 'y'))
                return true;
            else return false;
        } else return false;

    }

    public static String getSandwich(String str) {
        int counter = 0;
        int index = 0;
        while ((str.indexOf("bread", index)) != -1) {
            counter++;
            index = index + 5;
        }
        if (counter >= 2)
            return str.substring(str.indexOf("bread") + 5, str.lastIndexOf("bread"));
        else return ("");
    }

    public static boolean sameStarChar(String str) {
        int index = 0;
        boolean wynik = true;
        char znakpo, znakprzed;

        if (str.length() >= 3) {
            if (str.indexOf("*", index) == 0)
                index = 1;

            while (str.indexOf("*", index) != -1) {
                index = str.indexOf("*", index) + 1;
                if(index==str.length()) return wynik;
                znakpo = str.charAt(index);
                znakprzed = str.charAt(index - 2);
                if (znakpo == znakprzed) wynik = true;
                else return false;
            }
        } else return true;
        return wynik;
    }

    public static String oneTwo(String str) {
        int counter=0;
        String wynik ="";

        while(str.length()>=3){
            if(counter>str.length()-3) return wynik;
            else {wynik=wynik+str.substring(counter+1,counter+3) + str.substring(counter,counter+1);
                counter=counter+3;}
        }
        return wynik;
    }

    public static int bunnyEars2(int bunnies) {
        if (bunnies==0) return 0;
        if (bunnies%2!=0) return 2+ bunnyEars2(bunnies-1);
        return 3 + bunnyEars2(bunnies-1);
    }

    public static int triangle(int rows) {
        if(rows ==0) return 0;
        return rows+triangle(rows-1);
    }


    public static int sumDigits(int n) {
        if (n==0) return 0;
        return n%10 + sumDigits(n/10);
    }

    public static int count7(int n) {
        if(n==0) return 0;
        if(n%10==7) return 1 + count7(n/10);
        else return count7(n/10);
    }

    public static int count8(int n) {
        if(n==0) return 0;
        if(n%100==88) return 2 + count8(n/10);
        if(n%10==8) return 1 + count8(n/10);
        else return count8(n/10);
    }

    public static int powerN(int base, int n) {
        if(n==0) return 1;
        return(base*powerN(base,n-1));
    }


    public static int countX(String str) {
        if(str.length()==0) return 0;
        if(str.charAt(str.length()-1)=='x') return 1 + countX(str.substring(0,str.length()-1));
        else return countX(str.substring(0,str.length()-1));
    }

    public static int countHi(String str) {
        if(str.length()<2) return 0;
        if(str.substring(str.length()-2,str.length()).equals("hi")) return 1 + countHi(str.substring(0,str.length()-2));
        else return countHi(str.substring(0,str.length()-1));
    }


    public static String changeXY(String str) {
        if(str.length()==0) return "";
        if(str.charAt(str.length()-1)=='x') return changeXY(str.substring(0,str.length()-1))+"y";
        else return changeXY(str.substring(0,str.length()-1))+str.substring(str.length()-1,str.length());
    }


    public static String changePi(String str) {
        if(str.length()<2) return str;
        if(str.substring(str.length()-2,str.length()).equals("pi")) return changePi(str.substring(0,str.length()-2))+"3.14";
        else return changePi(str.substring(0,str.length()-1))+str.substring(str.length()-1,str.length());
    }

}

