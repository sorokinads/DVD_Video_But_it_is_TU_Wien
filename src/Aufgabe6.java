import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.events.EventScanner;

import java.awt.*;

// TODO: IN HONOR OF "DVD VIDEO"

/*
    Aufgabe 6) Designaufgabe
*/
public class Aufgabe6 {

    public static Color chooseColor(){
        Color color = Palette.randomColor();
        while (color == Palette.BLACK)
            color = Palette.randomColor();
        return color;
    }

    public static void drawTU(int x, int y, CodeDraw cd, Color c){
        cd.setColor(c);
        cd.drawRectangle(x, y, 132, 128);
        cd.fillRectangle(x + 12, y + 12, 50, 14); // T - =
        cd.fillRectangle(x + 12 + 18, y + 12 + 14 + 4, 14, 46); // T - ||
        cd.fillRectangle(x + 12 + 50 + 6, y + 12, 14, 38); // U - left rect. part
        cd.fillRectangle(x + 12 + 50 + 6 + 14 + 24, y + 12, 14, 38); // U - right rect. part
        cd.getTextFormat().setFontSize(32);
        cd.getTextFormat().setBold(true);
        cd.drawText(x + 12, y + 12 + 64 + 16, "W I E N");
        cd.fillCircle(x + 12 + 50 + 6 + 14 + 12, y + 12 + 38, 26); // Outer circle
        cd.setColor(Palette.BLACK);
        cd.fillCircle(x + 12 + 50 + 6 + 14 + 12, y + 12 + 38, 12); // Inner circle
        cd.fillRectangle(x + 12 + 50 + 6 + 14, y + 12, 24, 38); // Inner black rectangle
        cd.fillRectangle(x + 12 + 50 + 6 + 14 + 10, y + 12 + 50, 4, 14); // Inner lower black rectangle
    }

    public static void drawInf(int x, int y, CodeDraw cd, Color c){
        cd.setColor(c);
        cd.drawRectangle(x, y, 132, 128);
        cd.fillRectangle(x + 55.5, y + 18, 21, 59);
        cd.fillSquare(x + 55.5, y + 18 + 59 + 12, 21);
    }

    public static void main(String[] args) {
        CodeDraw cd = new CodeDraw(840, 560);
        EventScanner es = new EventScanner(cd);
        int x = 0;
        int y = 20;
        int dx = 4;
        int dy = 4;
        boolean flag = true;
        Color c = chooseColor();
        cd.setColor(c);
        cd.setLineWidth(7);
        while (!es.isClosed()) {
            if(flag)
                drawTU(x, y, cd, c);
            else
                drawInf(x, y, cd, c);
            cd.show();
            cd.clear(Palette.BLACK);
            x += dx;
            y += dy;
            if(y == (560 - 128) || y == 0){
                dy = -dy;
                c = chooseColor();
                cd.setColor(c);
                flag = !flag;
            }
            if(x == (840 - 132) || x == 0){
                dx = -dx;
                c = chooseColor();
                cd.setColor(c);
                flag = !flag;
            }
        }
    }
}
