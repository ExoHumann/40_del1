package spil;

public class Game {
   // private final Player player;
   // private final Player computer;
    //private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;
    private final Gui mainGui;


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

        /*for (int i = 0; i < gamesAmount; i++) {

            while (computer.getScore() < 40 && player.getScore() < 40) {
                pDice.roll();
                cDice.roll();

                player.setScore(player.getScore() + pDice.getSum());

                computer.setScore(computer.getScore() + cDice.getSum());
            }

            if (player.getScore() < computer.getScore()) {
                computer.setWin();
            } else if (computer.getScore() < player.getScore()) {
                player.setWin();
            } else if (player.getScore() == computer.getScore()) {
                player.setTie();
                computer.setTie();
            }


            player.setScore(0);
            computer.setScore(0);
        }*/
        boolean twoEqualsP1 = true;


        while(mainGui.GetScore(true) < 40 && mainGui.GetScore(false) < 40) {
            do{
                if (Gui.RollDiceAction(true)) {
                    pDice.roll();
                    mainGui.ShowDice(pDice.getDice1(), pDice.getDice2());
                    if (pDice.getEquals()) {
                        if (pDice.getDice1() == 1 || pDice.getDice2() == 1) {
                            mainGui.ResetPoints(true);
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
            while (twoEqualsP1 == true);


            boolean twoEqualsP2 = false;

            do {
                if (Gui.RollDiceAction(false)) {
                    cDice.roll();
                    mainGui.ShowDice(cDice.getDice1(), cDice.getDice2());
                    if (cDice.getEquals()) {
                        if (cDice.getDice1() == 1 || cDice.getDice2() == 1) {
                            mainGui.ResetPoints(false);
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
            while (twoEqualsP2 == true);

        }
    }
}
