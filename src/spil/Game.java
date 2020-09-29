package spil;

public class Game {
    private final Player player1;
    private final Player player2;
    //private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;
    private final Gui mainGui;
    private boolean twoSixesP1 = false;
    private boolean twoSixesP2 = false;
    private boolean gameEnd =false;


    public Game(Gui gui,int games, Dice cDice, Dice pDice,Player player1,Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.mainGui = gui;
        this.cDice = cDice;
        this.pDice = pDice;
        //gamesAmount = games;


        play();
        //displayWins(this.computer.getWin(), this.player.getWin());
        }

    /*public void displayWins(int computerWins, int playerWins) {
        System.out.println(player.getName() + " Has Won " + computerWins + " Games");
        System.out.println(computer.getName() + " Has Won " + playerWins + " Games");
        System.out.println("Tied games are " + player.getTie());
    }*/


    private void play() {


        while(!gameEnd) {
            do {
                if (mainGui.hasReachedGoalP1) {
                    if (Gui.RollDiceAction(player1)) {
                        pDice.roll();
                        mainGui.ShowDice(pDice.getDice1(), pDice.getDice2());
                        if (pDice.getEquals()) {
                            //Game end
                            gameEnd = true;
                            mainGui.GameEnd(player1);
                        }
                        else{
                        }
                    }
                } else {
                    if (Gui.RollDiceAction(player1)) {
                        pDice.roll();
                        mainGui.ShowDice(pDice.getDice1(), pDice.getDice2());
                        if (pDice.getEquals()) {
                            if (pDice.getDice1() == 1 || pDice.getDice2() == 1) {
                                mainGui.ResetPoints(player1);
                            } else if (pDice.getDice1() == 6) {
                                if (twoSixesP1) {
                                    //Player 1 rolled two sixes two times in a row
                                    mainGui.GameEnd(player1);
                                    gameEnd = true;
                                } else {
                                    twoSixesP1 = true;
                                }
                            } else {
                                mainGui.SetPoints(player1, pDice.getSum());
                            }
                        } else {
                            mainGui.SetPoints(player1, pDice.getSum());
                        }
                    } else {
                    }
                }
            }
                while (pDice.getEquals()) ;



                do {
                    if (mainGui.hasReachedGoalP2) {
                        if (Gui.RollDiceAction(player2)) {
                            cDice.roll();
                            mainGui.ShowDice(cDice.getDice1(), cDice.getDice2());
                            if (cDice.getEquals()) {
                                //Game end
                                gameEnd = true;
                                mainGui.GameEnd(player2);
                            }else{

                            }
                        }
                    } else {
                        if (Gui.RollDiceAction(player2)) {
                            cDice.roll();
                            mainGui.ShowDice(cDice.getDice1(), cDice.getDice2());
                            if (cDice.getEquals()) {
                                if (cDice.getDice1() == 1 || cDice.getDice2() == 1) {
                                    mainGui.ResetPoints(player2);
                                } else if (cDice.getDice1() == 6) {
                                    if (twoSixesP2) {
                                        //Player 2 rolled two sixes two times in a row
                                        mainGui.GameEnd(player2);
                                        gameEnd = true;
                                    } else {
                                        twoSixesP2 = true;
                                    }
                                } else {
                                    mainGui.SetPoints(player2, cDice.getSum());
                                }
                            } else {
                                mainGui.SetPoints(player2, cDice.getSum());
                            }
                        } else {
                        }
                    }
                }
                while (cDice.getEquals());
        }
    }
}
