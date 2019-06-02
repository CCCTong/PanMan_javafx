package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

public class MapData {

    public static List<GameObject> border;
    public static List<GameObject> pacDot;
    public static List<GameObject> monster;

    public static int Score = 0;
    public static int leftDot = 0;


    public static void InitBorder(){
        border = new ArrayList<GameObject>();
        CreateBorder(37,55,6,390);  // left border
        CreateBorder(417,55,6,390); // right border
        CreateBorder(38,57,385,6);  // top
        CreateBorder(38,439,385,6); // button
        CreateBorder(37,176,33,12); // ok
        CreateBorder(37,288,33,12); // ok
        CreateBorder(37,362,33,12); // ok
        CreateBorder(390,362,33,12); // ok
        CreateBorder(390,288,33,12); // ok
        CreateBorder(390,176,33,12); // ok
        CreateBorder(224,57,12,30); // ok
        CreateBorder(72,87,40,25); // ok
        CreateBorder(141,87,54,25); // ok
        CreateBorder(141,176,52,11); // ok
        CreateBorder(141,327,52,10); // ok
        CreateBorder(265,87,54,25); // ok
        CreateBorder(265,177,54,10); // ok
        CreateBorder(265,327,54,10); // ok
        CreateBorder(265,401,54,10); //ok
        CreateBorder(141,401,54,10);// ok
        CreateBorder(348,87,40,25); // ok
        CreateBorder(349,214,38,10); // ok
        CreateBorder(349,251,38,10); // ok
        CreateBorder(349,326,38,10); // ok
        CreateBorder(72,139,40,10); // ok
        CreateBorder(348,139,40,10); // ok .
        CreateBorder(348,401,40,10); // ok
        CreateBorder(72,401,39,10); // ok
        CreateBorder(72,213,39,11);
        CreateBorder(72,251,39,10); // ok
        CreateBorder(72,327,39,10); // ok
        CreateBorder(184,140,92,8); // ok
        CreateBorder(184,290,92,8); // ok
        CreateBorder(184,364,92,8); // ok
        CreateBorder(224,114,12,72); // ok
        CreateBorder(224,328,12,82); // ok
        CreateBorder(307,139,12,48); // ok
        CreateBorder(141,139,12,48); // ok
        CreateBorder(141,215,12,82); // ok
        CreateBorder(141,365,12,42); // ok
        CreateBorder(307,215,12,82); // ok
        CreateBorder(307,365,12,45); // ok
        CreateBorder(101,178,10,45); // ok
        CreateBorder(349,178,10,45); // ok
        CreateBorder(101,250,10,48); // ok
        CreateBorder(349,250,10,48); // ok
        CreateBorder(101,328,10,45); // ok
        CreateBorder(349,326,10,47); // ok
        CreateBorder(182,213,30,5); // ok
        CreateBorder(248,213,29,5); // ok
        CreateBorder(182,258,94,5); // ok
        CreateBorder(182,213,5,45); // ok
        CreateBorder(272,213,5,48); // ok
    }
    public static void CreateBorder(int x,int y,int width,int height){
        GameObject now = new GameObject();
        now.setX(x);
        now.setY(y);
        now.setWidth(width);
        now.setHeight(height);
        border.add(now);
    }
}
