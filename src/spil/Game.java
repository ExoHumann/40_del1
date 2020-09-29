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
                player.setScore(player.getScore() + pDice.roll());
                computer.setScore(computer.getScore() + cDice.roll());
                System.out.println(player.getName() + " " + pDice.getDice1() + "+" + pDice.getDice2() + "=" + pDice.getSum() + " Score= " + player.getScore());
                System.out.println(computer.getName() + " " + cDice.getDice1() + "+" + cDice.getDice2() + "=" + cDice.getSum() + " Score= " + computer.getScore());

                if (pDice.getEns()) {
                    if(pDice.getDice1() == 1){
                        player.setScore(0);
                    }
                    player.setScore(player.getScore() + pDice.roll());
                    System.out.println(player.getName() + " " + pDice.getSum() + " Score " + player.getScore());
                }
                if (cDice.getEns()) {
                    if(cDice.getDice1() == 1){
                        computer.setScore(0);
                    }
                    computer.setScore(computer.getScore() + cDice.roll());
                    System.out.println(computer.getName() + " " + cDice.getSum()  + " Score " + computer.getScore());
                }
            }

            if (player.getScore() > computer.getScore()) {
                computer.setWin();
            } else if (computer.getScore() > player.getScore()) {
                player.setWin();
            } else if (player.getScore() == computer.getScore()) {
                player.setTie();
                computer.setTie();
            }

            player.setScore(0);
            computer.setScore(0);
        }

    }}


