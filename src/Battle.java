import java.util.concurrent.TimeUnit;

public class Battle {
    private static final int ROUND = 1;


    //Deal damage
    public static void damage(Hero player1, Hero player2){

        int rollValue = Commands.roll(6);


        if(rollValue == 1 || rollValue == 2) {
            Commands.dealDamage(player1, player2);
            System.out.println("----------");
            Commands.dealDamage(player2, player1);
            System.out.println("----------");

        } else if (rollValue == 3 || rollValue == 4){
            Commands.dealDamage(player2, player1);
            System.out.println("----------");

            Commands.dealDamage(player1, player2);
            System.out.println("----------");

        } else if (rollValue == 5){
            Commands.dealDamage(player1, player2);
            System.out.println("----------");

        } else{
            Commands.dealDamage(player2, player1);
            System.out.println("----------");

        }

    }

    //run a match

    public static void match(Hero player1, Hero player2, int roundMax){
        player1.setTempHitpoints(player1.getHitPoints());
        player2.setTempHitpoints(player2.getHitPoints());

        System.out.println(player1);
        System.out.println("================VS================");
        System.out.println(player2);
        int r = ROUND;

        while(isFightOver(player1, player2)){
            int roundTimer = 0;
            int roll;
            System.out.println("================");
            System.out.println("Round " + r + " FIGHT!");
            System.out.println("================");
            try {
                while(roundTimer < roundMax && isFightOver(player1, player2)) {
                    roll = Commands.roll(10);
                    roundTimer = roundTimer + roll;
                    TimeUnit.SECONDS.sleep(roll);
                    timerPrint(roundTimer, roundMax);
                    damage(player1, player2);
                    if(isFightOver(player1, player2)){
                        restBetweenAttacks(player1);
                        restBetweenAttacks(player2);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("================");
            System.out.println("Round " + r + " OVER!");
            System.out.println("================");
            System.out.println();

            if(isFightOver(player1, player2)){
                restBetweenRounds(player1);
                restBetweenRounds(player2);
            }
            r++;
        }

        declareWinner(player1, player2);

    }

    //TODO create tournament()
    //TODO create tagTeam()
    //TODO create battleRoyale()
    //TODO create royalRumble()

    //Check to see if a player is knocked out
    public static boolean isKO(Hero player){
        return player.getTempHitpoints() <= 0;
    }

    //check to see if both player's are knocked out
    public static boolean isDraw(Hero player1, Hero player2){

        return isKO(player1) && isKO(player2);

    }

    //Checks to see if the fight is over
    public static boolean isFightOver(Hero player1, Hero player2){
        return !isKO(player1) && !isKO(player2) && !isDraw(player1, player2);
    }

    //Declares a winner
    public static void declareWinner(Hero player1, Hero player2){
        if(isKO(player1) && !isKO(player2)){
            player1.setLoss(player1.getLoss()+1);
            player2.setWin(player2.getWin()+1);
            System.out.println(player2.getName() + " wins by KO!");
        }else if(!isKO(player1) && isKO(player2)){
            player1.setWin(player1.getWin()+1);
            player2.setLoss(player2.getLoss()+1);
            System.out.println(player1.getName() + " wins by KO!");
        }else if(isDraw(player1, player2)){
            player1.setDraw(player1.getDraw()+1);
            player2.setDraw(player2.getDraw()+1);
            System.out.println("It's a draw!");
        }
    }

    //Regenerate stamina & mana between attacks

    public static void restBetweenAttacks(Hero player){
        Commands.regenerateStamina(player);
        Commands.regenerateMana(player);
    }

    //regenerate stamina, mana, and health between rounds
    public static void restBetweenRounds(Hero player){
        Commands.regenerateHitPoints(player);
        Commands.regenerateStaminaRounds(player);
        Commands.regenerateManaRounds(player);
    }
    //Prints a timer output
    public static void timerPrint(int roundTimer, int roundMax){
        int minutes = roundTimer / 60;
        int seconds = roundTimer % 60;

        if(roundTimer >= roundMax){
            System.out.println("====="+ minutes +":"+ "00"+"=====");
        }else if(seconds < 10){
            System.out.println("====="+ minutes +":"+ "0" + seconds + "=====");
        } else{
            System.out.println("====="+ minutes +":"+ seconds + "=====");
        }
    }
}
