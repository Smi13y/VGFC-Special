public class Commands {
    private static int rollValue, lp, mp, hp, lk, mk, hk, lm, mm, hm, damage;
    private static String attackType;
    private static String lmh, lmhOutput;
    private static boolean isCrit;
    static final int D20 = 20;
    static final int D12 = 12;
    static final int D10 = 10;
    static final int D8 = 8;
    static final int D6 = 6;
    static final int D4 = 4;
    static final int D2 = 2;

    public static int roll(int index){
        rollValue = (int) (Math.random()*index)+1;
        return rollValue;
    }

    public static int dodgeOrBlock(int damage, String lmh, Character player){
        rollValue = roll(D10);

        if(rollValue <= player.getDodgeBlock()){
            rollValue = roll(D2);
            if(rollValue == 1){
                damage = damage * 2;
            } else{
                damage = 0;
            }
        } else{
            String attack = lmh;
            if(attack.equals("LightPunch") || attack.equals("LightKick") || attack.equals("LightMagic")){
                damage = damage - roll(D2);
            } else if(attack.equals("MediumPunch") || attack.equals("MediumKick") || attack.equals("MediumMagic")){
                damage = damage - roll(D4);
            } else{
                damage = damage - roll(D6);
            }
        }
        return damage;
    }
    public static int dealDamage(String lmh, boolean isCrit, Character player){
        switch(lmh){
            case "LightPunch":
                damage = roll(D4) + (player.getLightPunchAttack() - 3);
                if(isCrit)
                    damage = 2 * (4 + player.getLightPunchAttack() - 3);
            case "MediumPunch":
                damage = roll(D6) + (player.getMediumPunchAttack() - 3);
                if(isCrit)
                    damage = 2 * (6 + player.getMediumPunchAttack() - 3);
            case "HeavyPunch":
                damage = roll(D8) + (player.getHeavyPunchAttack() - 3);
                if(isCrit)
                    damage = 2 * (8 + player.getHeavyPunchAttack() - 3);
            case "LightKick":
                damage = roll(D4) + (player.getLightKickAttack() - 3);
                if(isCrit)
                    damage = 2 * (4 + player.getLightKickAttack() - 3);
            case "MediumKick":
                damage = roll(D6) + (player.getMediumKickAttack() - 3);
                if(isCrit)
                    damage = 2 * (6 + player.getMediumKickAttack() - 3);
            case "HeavyKick":
                damage = roll(D8) + (player.getHeavyKickAttack() - 3);
                if(isCrit)
                    damage = 2 * (8 + player.getHeavyKickAttack() - 3);
            case "LightMagic":
                damage = roll(D4) + (player.getLightMagicAttack() - 3);
                if(isCrit)
                    damage = 2 * (4 + player.getLightMagicAttack() - 3);
            case "MediumMagic":
                damage = roll(D6) + (player.getMediumMagicAttack() - 3);
                if(isCrit)
                    damage = 2 * (6 + player.getMediumMagicAttack() - 3);
            case "HeavyMagic":
                damage = roll(D8) + (player.getHeavyMagicAttack() - 3);
                if(isCrit)
                    damage = 2 * (8 + player.getHeavyMagicAttack() - 3);
        }

        if(damage < 0)
            damage = 0;

        return damage;
    }

    public boolean isHit(String lmh, Character player1, Character player2){
            int roll1 = roll(D20);
            int roll2 = roll(D20);
            if(roll1 == 20)
                isCrit = true;
            else
                isCrit = false;
        switch(lmh){
            case "LightPunch":
                if(((roll1 + player1.getLightPunchAttack()) >= (roll2 + player2.getPunchBlock()) || isCrit) && player1.getTempStamina() >= 1){
                    return true;
                }
            case "MediumPunch":
                if(((roll1 + player1.getMediumPunchAttack()) >= (roll2 + player2.getPunchBlock()) || isCrit) && player1.getTempStamina() >= 3){
                    return true;
                }
            case "HeavyPunch":
                if(((roll1 + player1.getHeavyPunchAttack()) >= (roll2 + player2.getPunchBlock()) || isCrit) && player1.getTempStamina() >= 5){
                    return true;
                }
            case "LightKick":
                if(((roll1 + player1.getLightKickAttack()) >= (roll2 + player2.getKickBlock()) || isCrit) && player1.getTempStamina() >= 1){
                    return true;
                }
            case "MediumKick":
                if(((roll1 + player1.getMediumKickAttack()) >= (roll2 + player2.getKickBlock()) || isCrit) && player1.getTempStamina() >= 3){
                    return true;
                }
            case "HeavyKick":
                if(((roll1 + player1.getHeavyKickAttack()) >= (roll2 + player2.getKickBlock()) || isCrit) && player1.getTempStamina() >= 5){
                    return true;
                }
            case "LightMagic":
                if(((roll1 + player1.getLightMagicAttack()) >= (roll2 + player2.getMagicBlock()) || isCrit) && player1.getTempMana() >= 1){
                    return true;
                }
            case "MediumMagic":
                if(((roll1 + player1.getMediumMagicAttack()) >= (roll2 + player2.getMagicBlock()) || isCrit) && player1.getTempMana() >= 3){
                    return true;
                }
            case "HeavyMagic":
                if(((roll1 + player1.getHeavyMagicAttack()) >= (roll2 + player2.getMagicBlock()) || isCrit) && player1.getTempMana() >= 5){
                    return true;
                }
        }

        return false;
    }
    public static String getAttackType(Character player){
        rollValue = roll(10);

        switch(player.getFightStyle()){
            case "Balance":
                rollValue = roll(9);
                if(rollValue < 4)
                    attackType = "Punch";
                else if(rollValue > 3 && rollValue < 7)
                    attackType = "Kick";
                else if(rollValue > 6)
                    attackType = "Magic";
            case "Boxer":
                if(rollValue < 7)
                    attackType = "Punch";
                else if(rollValue < 9 && rollValue > 6)
                    attackType = "Kick";
                else if(rollValue > 8)
                    attackType = "Magic";
            case "Kickboxer":
                if(rollValue < 7)
                    attackType = "Kick";
                else if(rollValue < 9 && rollValue > 6)
                    attackType = "Punch";
                else if(rollValue > 8)
                    attackType = "Magic";
            case "Magician":
                if(rollValue < 7)
                    attackType = "Magic";
                else if(rollValue < 9 && rollValue > 6)
                    attackType = "Punch";
                else if(rollValue > 8)
                    attackType = "Kick";
            case "MMA":
                if(rollValue < 5)
                    attackType = "Punch";
                else if(rollValue > 4 && rollValue < 9)
                    attackType = "Kick";
                else if(rollValue > 8)
                    attackType = "Magic";
        }
        return attackType;
    }

    public static String determineLMH(Character player){
        attackType = getAttackType(player);
        lp = player.getLightPunchAttack();
        mp = player.getMediumPunchAttack();
        hp = player.getHeavyPunchAttack();
        lk = player.getLightKickAttack();
        mk = player.getMediumKickAttack();
        hk = player.getHeavyKickAttack();
        lm = player.getLightMagicAttack();
        mm = player.getMediumMagicAttack();
        hm = player.getHeavyMagicAttack();

        switch(attackType){
            case "Punch":
                rollValue = roll(lp + mp + hp);
                if(rollValue <= lp)
                    lmh = "LightPunch";
                else if(rollValue > lp && rollValue <= (lp+ mp))
                    lmh = "MediumPunch";
                else if(rollValue > (lp + mp));
                    lmh = "HeavyPunch";
            case "Kick":
                rollValue = roll(lk + mk + hk);
                if(rollValue <= lk)
                    lmh = "LightKick";
                else if(rollValue > lk && rollValue <= (lk+ mk))
                    lmh = "MediumKick";
                else if(rollValue > (lk + mk));
                lmh = "HeavyKick";
            case "Magic":
                rollValue = roll(lm + mm + hm);
                if(rollValue <= lm)
                    lmh = "LightPunch";
                else if(rollValue > lm && rollValue <= (lm+ mm))
                    lmh = "MediumPunch";
                else if(rollValue > (lm + mm));
                lmh = "HeavyPunch";

        }
        return lmh;
    }

    public void getlmhOuput(String lmh){
        switch(lmh){
            case "LightPunch":
                lmhOutput = " does a quick jab!";
            case "MediumPunch":
                lmhOutput = " goes for the haymaker!";
            case "HeavyPunch":
                lmhOutput = " winds up with an uppercut!";
            case "LightKick":
                lmhOutput = " does a snap kick";
            case "MediumKick":
                lmhOutput = " goes for the roundhouse!";
            case "HeavyKick":
                lmhOutput = " unleashes a powerful side kick";
            case "LightMagic":
                lmhOutput = " throws a magic missile";
            case "MediumMagic":
                lmhOutput = " charges up for a fireball!";
            case "HeavyMagic":
                lmhOutput = " unleashes a beam of energy!";
            default:
                lmhOutput = "does nothing!";
        }

        System.out.println(lmhOutput);
    }

}
