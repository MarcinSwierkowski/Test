package pl.sda.Party;

public class PartyApp {

    public static void main(String[] args) {

        Party impreza1 = new Party("Koncert AC/DC",10);
        Party impreza2 = new Party("Urodziny Józka",30);
        Party impreza3 = new Party("Degustowanie Wódki",5);

        impreza1.addPartyMembers();

        System.out.println("---------------------");
        System.out.println(impreza1);


        impreza1.addPartyMembers();

        System.out.println("---------------------");
        System.out.println(impreza1);

        impreza1.removePartyMembers();

        System.out.println("---------------------");
        System.out.println(impreza1);



    }

}
