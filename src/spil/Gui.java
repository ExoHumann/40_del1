package spil;

import gui_fields.*;
import gui_main.GUI;
import java.awt.*;

public class Gui {

    static gui_main.GUI gui;
    static GUI_Field[] fields;
    static GUI_Player player1;
    static GUI_Player player2;
    static boolean hasReachedGoalP1 =false;
    static boolean hasReachedGoalP2 =false;


    /**
     * Creates and returns GUI object with 2 players
     * @return GUI
     */
    public Gui(){
        fields = new GUI_Field[40];

        GUI_Street street = new GUI_Street(); //Create new empty street tile

        //Populate the entire fields array with street tile
        for(int i =0;i<40;i++){
            fields[i]=new GUI_Street(String.valueOf(i+1),"","","",Color.green,Color.red);
        }
        //Set the subText of the first field to "start"
        fields[0].setSubText("Start");

        //Make the GUI with the created fields array and background color of green
        gui_main.GUI gui = new gui_main.GUI(fields,Color.green);

        //Create a car for each player
        GUI_Car car1 = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car car2 = new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

        //Get the player names and create player object
        String playerName1 = gui.getUserString("Indtast spiller 1");
        player1 = new GUI_Player(playerName1,0,car1);
        fields[0].setCar(player1, true);
        String playerName2 = gui.getUserString("Indtast spiller 2");
        player2 = new GUI_Player(playerName2,0,car2);
        fields[0].setCar(player2, true);

        //Add the players to the GUI board
        gui.addPlayer(player2);
        gui.addPlayer(player1);

        this.gui = gui;
        //return gui;
    }

    /**
     * Asks the selected player to roll the dice
     * @param player true for player 1, false for player 2
     * @return wether or not to roll the dice.
     */
    public static boolean RollDiceAction(boolean player){

        boolean selection = false;

        if (player){
            selection = gui.getUserLeftButtonPressed(player1.getName()+", do you want to roll dice?","Yes","No");
            return selection;
        }
        else if(!player){
            selection = gui.getUserLeftButtonPressed(player2.getName()+", do you want to roll dice?","Yes","No");
            return selection;
        }

        return selection;

    }

    /**
     * Method to show dice on the gui
     * @param dice1 number on the first dice
     * @param dice2 number on the second dice
     */
    public static void ShowDice(int dice1,int dice2){
        gui.setDice(dice1,dice2);
    }

    /**
     * Method to update the selected players point total
     * @param player true for player 1, false for player 2
     * @param pointsToAdd number of points to add to the players total
     */
    public static void SetPoints(boolean player,int pointsToAdd){
        if (player){
            int field = GetCurrentField(player1);
            //Check if the other player is on the same field
            if (fields[field].hasCar(player2)){
                fields[field].removeAllCars(); //Remove all the cars from the field
                fields[field].setCar(player2,true); //Add the second player back onto the field
            }
            else{
                fields[field].removeAllCars(); //Remove all the cars from the field
            }
            if(field+pointsToAdd>=40){
                fields[39].setCar(player1,true);
            }else{
                fields[field+pointsToAdd].setCar(player1,true); //Update the score tracker of player 1
                player1.setBalance(field+pointsToAdd); //Update the score balance of player 1
                hasReachedGoalP1 = true;
            }

        }
        else if(!player){
            int field = GetCurrentField(player2);
            if (fields[field].hasCar(player1)){
                fields[field].removeAllCars();
                fields[field].setCar(player1,true);
            }
            else{
                fields[field].removeAllCars();
            }
            if(field+pointsToAdd>=40){
                fields[39].setCar(player2,true);
            }else{
                fields[field+pointsToAdd].setCar(player2,true); //Update the score tracker of player 1
                player2.setBalance(field+pointsToAdd); //Update the score balance of player 1
            }
        }
    }

    /**
     * Returns the field number of where the selected player is located on the board.
     * @param player The player to look for on the board
     * @return Current field number
     */
    private static int GetCurrentField(GUI_Player player){
        int currentField = 0;

        //Checks all tiles in the field array, for the selected player.
        for(int i =0;i<40;i++){
            if(fields[i].hasCar(player)){
                currentField = i; //If the player has been found, save the current field number, and break
                break;
            }
            else{
                //NOTHING
            }
        }
        return currentField;
    }

    /**
     * Reset the selected players points
     * @param player true for player 1, false for player 2
     */
    public static void ResetPoints(boolean player){
        if(player){
            int field = GetCurrentField(player1);
            if (fields[field].hasCar(player2)){
                fields[field].removeAllCars();
                fields[field].setCar(player2,true);
            }
            else{
                fields[field].removeAllCars();
            }
            fields[0].setCar(player1,true);
            player1.setBalance(0);
        }
        else if(!player){
            int field = GetCurrentField(player2);
            if (fields[field].hasCar(player1)){
                fields[field].removeAllCars();
                fields[field].setCar(player1,true);
            }
            else{
                fields[field].removeAllCars();
            }
            fields[0].setCar(player2,true);
            player2.setBalance(0);
        }
    }

    /**
     * Shows game end message, the selected player wins
     * @param player true for player 1, false for player 2
     */
    public static void GameEnd(boolean player){
        if (player){
            gui.showMessage(player1.getName()+" You Win!");
        }
        else if(!player){
            gui.showMessage(player2.getName()+" You Win!");
        }

    }

    public static int GetScore(boolean player){
        if (player){
            return player1.getBalance();
        }
        else {
            return player2.getBalance();
        }
    }

}
