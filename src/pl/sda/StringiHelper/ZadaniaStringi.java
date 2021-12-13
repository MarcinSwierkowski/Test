package pl.sda.StringiHelper;

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


        StringHelp text = new StringHelp(testowy);

        text.wypiszStatystykeTextuLitery();

        //text.wypiszStatystykeTextuWyrazyV1();

        text.wypiszStatystykeTextuWyrazyV2();

        //zlacz(testowy3,testowy4);
        //usunWgRegex(testowy3,regexSamogloski," ");
        //usunWgRegex(testowy4,regexDwucyfroweLiczby," ");
        //usunWgRegex(testowy4,regexWyrazDuzejLitery,"???");
        //usunWgRegex(testowy4,regexKoniecTextu,testowy4.charAt(testowy4.length()-1) + "\n");
        //odwrocStringa(testowy2);
        //sprawdzNawiasy(nawiasy3);
        //szyfrCezara(testowy5, 2);

    }


}

