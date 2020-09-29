package spil;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class Player extends GUI_Player {

    private String name;
    private int score;
    private int win = 0;
    private int tie = 0;

    public Player(String playerName, int balance, GUI_Car car) {
        super(playerName, balance, car);
        this.name = playerName;
    }

   /* public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }*/

    public void setWin(){ this.win++; }
    public int getWin(){ return this.win; }

    public void setTie(){ this.tie++; }
    public int getTie(){ return this.tie; }

    public void setScore(int score){ this.score = score; }
    public int getScore(){ return score; }

}
