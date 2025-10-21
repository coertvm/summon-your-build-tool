package codewarts;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class MadHatter {

    public static void main(String[] args) throws IOException {
        String ascii = new SortingHat().summon();
        String art = FigletFont.convertOneLine(ascii);
        System.out.println(SortingHat.INCANTATION);
        System.out.println(SortingHat.PRONOUNCEMENT);
        System.out.println(art);
    }
}
