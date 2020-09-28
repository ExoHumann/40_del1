package spil;

public class Game {
   // private final Player player;
   // private final Player computer;
    //private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;
    private final Gui mainGui;
    private boolean twoSixesP1 = false;
    private boolean twoSixesP2 = false;
    private boolean gameEnd =false;


    public Game(Gui gui,int games, Dice cDice, Dice pDice){
       /* this.player = player;
        this.computer = computer;*/
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
        boolean twoEqualsP1 = true;


        while(!gameEnd) {
            do {
                if (mainGui.hasReachedGoalP1) {
                    if (Gui.RollDiceAction(true)) {
                        pDice.roll();
                        mainGui.ShowDice(pDice.getDice1(), pDice.getDice2());
                        if (pDice.getEquals()) {
                            //Game end
                            gameEnd = true;
                            mainGui.GameEnd(true);
                        }
                        else{
                            twoEqualsP1 = false;
                            break;
                        }
                    }
                } else {
                    if (Gui.RollDiceAction(true)) {
                        pDice.roll();
                        mainGui.ShowDice(pDice.getDice1(), pDice.getDice2());
                        if (pDice.getEquals()) {
                            if (pDice.getDice1() == 1 || pDice.getDice2() == 1) {
                                mainGui.ResetPoints(true);
                            } else if (pDice.getDice1() == 6 || pDice.getDice2() == 6) {
                                if (twoSixesP1) {
                                    //Player 1 rolled two sixes two times in a row
                                    mainGui.GameEnd(true);
                                    gameEnd = true;
                                } else {
                                    twoSixesP1 = true;
                                }
                            } else {
                                mainGui.SetPoints(true, pDice.getSum());
                                twoEqualsP1 = true;
                            }
                        } else {
                            mainGui.SetPoints(true, pDice.getSum());
                            twoEqualsP1 = false;
                        }
                    } else {
                        twoEqualsP1 = false;
                    }
                }
            }
                while (twoEqualsP1 == true) ;


                boolean twoEqualsP2 = false;

                do {
                    if (mainGui.hasReachedGoalP2) {
                        if (Gui.RollDiceAction(true)) {
                            cDice.roll();
                            mainGui.ShowDice(cDice.getDice1(), cDice.getDice2());
                            if (cDice.getEquals()) {
                                //Game end
                                gameEnd = true;
                                mainGui.GameEnd(false);
                            }else{
                                twoEqualsP2 = false;
                                break;
                            }
                        }
                    } else {
                        if (Gui.RollDiceAction(false)) {
                            cDice.roll();
                            mainGui.ShowDice(cDice.getDice1(), cDice.getDice2());
                            if (cDice.getEquals()) {
                                if (cDice.getDice1() == 1 || cDice.getDice2() == 1) {
                                    mainGui.ResetPoints(false);
                                } else if (cDice.getDice1() == 6 || cDice.getDice2() == 6) {
                                    if (twoSixesP2) {
                                        //Player 1 rolled two sixes two times in a row
                                        mainGui.GameEnd(true);
                                        gameEnd = true;
                                    } else {
                                        twoSixesP2 = true;
                                    }
                                } else {
                                    mainGui.SetPoints(false, cDice.getSum());
                                    twoEqualsP2 = true;
                                }
                            } else {
                                twoEqualsP2 = false;
                                mainGui.SetPoints(false, cDice.getSum());
                            }
                        } else {
                            twoEqualsP2 = false;
                        }
                    }
                }
                while (twoEqualsP2 == true);
        }
    }
}
