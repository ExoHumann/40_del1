package spil;

import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scanner in = new Scanner(System.in);

        /*
        System.out.println("Set your name");
        String pName = in.nextLine();
        System.out.println("Set computers name");
        String cName = in.nextLine();

        Player player = new Player(pName, 0);
        Player computer = new Player(cName, 0);
        */

        Gui gameGui = new Gui();

        GUI_Car car1 = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car car2 = new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

        Player player1 = new Player(gameGui.GetPlayerName(),0,car1);
        Player player2 = new Player(gameGui.GetPlayerName(),0,car2);
        gameGui.AddPlayers(player1,player2);


        Dice cDice = new Dice(0,0);
        Dice pDice = new Dice(0,0);

        new Game(gameGui,1000, cDice, pDice,player1,player2);

    }
}
