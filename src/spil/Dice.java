package spil;

import java.util.Random;

public class Dice {

    private int dice1;
    private int dice2;


    public Dice(int dice1, int dice2) {
        this.dice1 = dice1;
        this.dice2 = dice2;
        roll();
    }


    public int roll(){
        Random r = new Random();
        dice1 = r.nextInt(6)+1;
        dice2 = r.nextInt(6)+1;
        return getSum();
    }

    boolean getEquals(){
        return dice1 == dice2;
    }

    public void setDice(int dice1, int dice2) { this.dice1 = dice1; this.dice2 = dice2;}
    public int getDice1() { return dice1; }
    public int getDice2() { return dice2; }
    public int getSum() { return dice1 + dice2;}


    public String toString(){
        return Integer.toString(dice2);
    }
}

