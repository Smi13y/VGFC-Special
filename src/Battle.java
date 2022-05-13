import java.util.concurrent.TimeUnit;

public class Battle {
    private static int roundTimer, minutes, seconds, roundMax;
    private String timerOutput;
    private static final int ROUND = 1;


    //Deal damage
    public static void damage(Character player1, Character player2){

        int rollValue = Commands.roll(6);

        if(rollValue == 1 || rollValue == 2) {
            Commands.dealDamage(player1, player2);
            Commands.dealDamage(player2, player1);
        } else if (rollValue == 3 || rollValue == 4){
            Commands.dealDamage(player2, player1);
            Commands.dealDamage(player1, player2);
        } else if (rollValue == 5){
            Commands.dealDamage(player1, player2);
        } else{
            Commands.dealDamage(player2, player1);
        }

    }

    //run a match

    public static void match(Character player1, Character player2, int roundMax){
        player1.setTempHitpoints(player1.getHitPoints());
        player2.setTempHitpoints(player2.getHitPoints());
        int r = ROUND;

        while(!isFightOver(player1, player2)){
            roundTimer = 0;
            int roll;
            System.out.println("================");
            System.out.println("Round " + r + " FIGHT!");
            System.out.println("================");
            try {
                while(roundTimer < roundMax && !isFightOver(player1, player2)) {
                    roll = Commands.roll(10);
                    roundTimer = roundTimer + roll;
                    TimeUnit.SECONDS.sleep(roll);
                    timerPrint(roundTimer, roundMax);
                    damage(player1, player2);
                    if(!isFightOver(player1, player2)){
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
            System.out.println("");

            if(!isFightOver(player1, player2)){
                Commands.regenerateHitPoints(player1);
                Commands.regenerateStaminaRounds(player1);
                Commands.regenerateManaRounds(player1);

                Commands.regenerateHitPoints(player2);
                Commands.regenerateStaminaRounds(player2);
                Commands.regenerateManaRounds(player2);

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
    public static boolean isKO(Character player){
        return player.getTempHitpoints() <= 0;
    }

    //check to see if both player's are knocked out
    public static boolean isDraw(Character player1, Character player2){

        if(isKO(player1) && isKO(player2)){
            return true;
        } else{
            return false;
        }

    }

    //Checks to see if the fight is over
    public static boolean isFightOver(Character player1, Character player2){
        if(isKO(player1) || isKO(player2) || isDraw(player1, player2)){
            return true;
        }
        return false;
    }

    //Declares a winner
    public static void declareWinner(Character player1, Character player2){
        if(isKO(player1) && !isKO(player2)){
            System.out.println(player2.getName() + " wins by KO!");
        }else if(!isKO(player1) && isKO(player2)){
            System.out.println(player1.getName() + " wins by KO!");
        }else if(isDraw(player1, player2)){
            System.out.println("It's a draw!");
        }
    }

    //Regenerate stamina & mana between attacks

    public static void restBetweenAttacks(Character player){
        Commands.regenerateStamina(player);
        Commands.regenerateMana(player);
    }

    //regenerate stamina, mana, and health between rounds
    public static void restBetweenRounds(Character player){
        Commands.regenerateStaminaRounds(player);
        Commands.regenerateManaRounds(player);
        Commands.regenerateHitPoints(player);
    }
    //Prints a timer output
    public static void timerPrint(int roundTimer, int roundMax){
        minutes = roundTimer / 60;
        seconds = roundTimer % 60;

        if(roundTimer >= roundMax){
            System.out.println("====="+minutes+":"+ "00"+"=====");
        }else if(seconds < 10){
            System.out.println("====="+minutes+":"+ "0" + seconds + "=====");
        } else{
            System.out.println("====="+minutes+":"+seconds + "=====");
        }
    }
}
