package spil;

public class Game {
    private final Player player;
    private final Player computer;
    private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;


    public Game(Player player, Player computer, int games, Dice cDice, Dice pDice){
        this.player = player;
        this.computer = computer;
        this.cDice = cDice;
        this.pDice = pDice;
        gamesAmount = games;


        play();
        displayWins(this.computer.getWin(), this.player.getWin());
        }

    public void displayWins(int computerWins, int playerWins) {
        System.out.println(player.getName() + " Has Won " + computerWins + " Games");
        System.out.println(computer.getName() + " Has Won " + playerWins + " Games");
        System.out.println("Tied games are " + player.getTie());
    }


    private void play() {

        for (int i = 0; i < gamesAmount; i++) {

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
        }


    }
}
