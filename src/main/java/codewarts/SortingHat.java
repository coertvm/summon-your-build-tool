package codewarts;

import java.util.Random;

public class SortingHat {

    public static final String INCANTATION = "Strong in syntax, sharp in mind, the right tool now I must find...";
    public static final String PRONOUNCEMENT = "It shall be...";

    public String summon() {
        String[] tools = { "Javador", "Makeclaw", "Antforge", "Mavenmere", "Gradlewraith" };
        int index = new Random().nextInt(tools.length);
        return tools[index];
    }

    public static void main(String[] args) {
        String ascii = new SortingHat().summon();
        System.out.println(INCANTATION);
        System.out.println(PRONOUNCEMENT);
        System.out.println(ascii);
    }
}
