public class Commands {
    private static int rollValue, damage;
    private static String attackType;
    private static String lmh;
    private static boolean isCrit;
    static final int D20 = 20;
    static final int D12 = 12;
    static final int D10 = 10;
    static final int D8 = 8;
    static final int D6 = 6;
    static final int D4 = 4;
    static final int D3 = 3;
    static final int D2 = 2;
    private static final int light = 1;
    private static final int medium = 3;
    private static final int heavy = 5;

    //regenerates hitpoints between rounds

    public static void regenerateHitPoints(Hero player){
        rollValue = roll(D12);
        if(player.getTempHitpoints() + rollValue > player.getHitPoints())
            player.setTempHitpoints(player.getHitPoints());
        else
            player.setTempHitpoints(player.getTempHitpoints() + rollValue);

        System.out.println(player.getName() + "regenerated " + rollValue + " health.");
    }

    //regenerates stamina between attacks
    public static void regenerateStamina(Hero player){
        rollValue = roll(D3);
        if(player.getTempStamina() + rollValue > player.getStamina())
            player.setTempStamina(player.getStamina());
        else
            player.setTempStamina(player.getTempStamina() + rollValue);

        //System.out.println(player.getName() + " regenerated " + rollValue + " stamina.");
    }

    public static void regenerateStaminaRounds(Hero player){
        rollValue = roll(D12);
        if(player.getTempStamina() + rollValue > player.getStamina())
            player.setTempStamina(player.getStamina());
        else
            player.setTempStamina(player.getTempStamina() + rollValue);

        System.out.println(player.getName() + " regenerated " + rollValue + " stamina.");

    }

    //regenerates mana between attacks
    public static void regenerateMana(Hero player){
        rollValue = roll(D4);
        if(player.getTempMana() + rollValue > player.getMana())
            player.setTempMana(player.getMana());
        else
            player.setTempMana(player.getTempMana() + rollValue);

        //System.out.println(player.getName() + " regenerated " + rollValue + " mana.");
    }

    public static void regenerateManaRounds(Hero player){
        rollValue = roll(D12);
        if(player.getTempMana() + rollValue > player.getMana())
            player.setTempMana(player.getMana());
        else
            player.setTempMana(player.getTempMana() + rollValue);

        System.out.println(player.getName() + " regenerated " + rollValue + " mana.");

    }

    //Roll a die with values 1-index inclusive
    public static int roll(int index){
        rollValue = (int) (Math.random()*index)+1;
        return rollValue;
    }

    //Roll a die with values 0-index inclusive
    public static int rollW0(int index){
        rollValue = (int) (Math.random()*index);
        return rollValue;
    }

    //Determines whether a player is KO'd
    public boolean isKO(Hero player){
        return player.getTempHitpoints() <= 0;
    }

    //Calculates the damage player 1 deals to player 2 after considering dodgeBlock
    public static void dealDamage(Hero player1, Hero player2){
        String tempLMH = determineLMH(player1);
        boolean hit = isHit(tempLMH, player1, player2);
        int d;
        int newD;

        System.out.println(player1.getName() + " goes for the attack.");
        getlmhOuput(tempLMH);

        if(hit) {
            d = calcDamage(tempLMH, isCrit, player1);
           newD = dodgeOrBlock(d, tempLMH, player2);
           if(newD <=0){
               newD = 0;
           }
            player2.setTempHitpoints(player2.getTempHitpoints()-newD);
            System.out.println(player1.getName() + " dealt " + newD + " damage to " + player2.getName());
        } else{
            System.out.println(player1.getName() + " misses!");
        }

        System.out.println(player2.getName() + ": " + player2.getTempHitpoints() + "/" + player2.getHitPoints() + " HP");


    }

    //Determines how much damage is blocked or dodged
    public static int dodgeOrBlock(int damage, String lmh, Hero player) {
        rollValue = roll(D10);
        int r;
        if(isCrit){
            System.out.println(player.getName() + " takes the full hit!");
            return damage;
        }else if(rollValue <= player.getDodgeBlock()){
            rollValue = roll(D2);
            if(rollValue == 1){
                damage = damage * 2;
            } else{
                damage = 0;
                System.out.println(player.getName() + " dodges out of the way!");
            }
        } else{
            rollValue = roll(D3);
            if(rollValue == 3) {
                if (lmh.equals("LightPunch") || lmh.equals("LightKick") || lmh.equals("LightMagic")) {
                    System.out.println(player.getName() + " tries to block!");
                    r = rollW0(D2);
                    if (r > 0) {
                        System.out.println(player.getName() + " blocks " + r + " damage!");
                    } else {
                        System.out.println(player.getName() + " takes the full hit!");
                    }
                    damage = damage - r;
                } else if (lmh.equals("MediumPunch") || lmh.equals("MediumKick") || lmh.equals("MediumMagic")) {
                    System.out.println(player.getName() + " tries to block!");
                    r = rollW0(D4);
                    if (r > 0) {
                        System.out.println(player.getName() + " blocks " + r + " damage!");
                    } else {
                        System.out.println(player.getName() + " takes the full hit!");
                    }
                    damage = damage - r;
                } else {
                    System.out.println(player.getName() + " tries to block!");
                    r = rollW0(D6);
                    if (r > 0) {
                        System.out.println(player.getName() + " blocks " + r + " damage!");
                    } else {
                        System.out.println(player.getName() + " takes the full hit!");
                    }
                    damage = damage - r;
                }
            } else{
                System.out.println(player.getName() + " takes the full hit!");
            }
        }
        return damage;
    }

    //Calculates damage a player deals based on the type of attack and whether it is a critical strike
    public static int calcDamage(String lmh, boolean isCrit, Hero player){
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

    //determines whether player1 hits player2 and if it is a critical strike
    public static boolean isHit(String lmh, Hero player1, Hero player2){
            int roll1 = roll(D20);
            int roll2 = roll(D20);
            if(roll1 == 20) {
                isCrit = true;
                System.out.println(player1.getName() + " lands a critical hit!");
            }else
                isCrit = false;
        switch(lmh){
            case "LightPunch":
                if(((roll1 + player1.getLightPunchAttack()) >= (roll2 + player2.getPunchBlock()) || isCrit) && player1.getTempStamina() >= light){
                    player1.setTempStamina(player1.getStamina() - light);
                    return true;
                }
            case "MediumPunch":
                if(((roll1 + player1.getMediumPunchAttack()) >= (roll2 + player2.getPunchBlock()) || isCrit) && player1.getTempStamina() >= medium){
                    player1.setTempStamina(player1.getStamina() - medium);
                    return true;
                }
            case "HeavyPunch":
                if(((roll1 + player1.getHeavyPunchAttack()) >= (roll2 + player2.getPunchBlock()) || isCrit) && player1.getTempStamina() >= heavy){
                    player1.setTempStamina(player1.getStamina() - heavy);
                    return true;
                }
            case "LightKick":
                if(((roll1 + player1.getLightKickAttack()) >= (roll2 + player2.getKickBlock()) || isCrit) && player1.getTempStamina() >= light){
                    player1.setTempStamina(player1.getStamina() - light);
                    return true;
                }
            case "MediumKick":
                if(((roll1 + player1.getMediumKickAttack()) >= (roll2 + player2.getKickBlock()) || isCrit) && player1.getTempStamina() >= medium){
                    player1.setTempStamina(player1.getStamina() - medium);
                    return true;
                }
            case "HeavyKick":
                if(((roll1 + player1.getHeavyKickAttack()) >= (roll2 + player2.getKickBlock()) || isCrit) && player1.getTempStamina() >= heavy){
                    player1.setTempStamina(player1.getStamina() - heavy);
                    return true;
                }
            case "LightMagic":
                if(((roll1 + player1.getLightMagicAttack()) >= (roll2 + player2.getMagicBlock()) || isCrit) && player1.getTempMana() >= light){
                    player1.setTempMana(player1.getTempMana() - light);
                    return true;
                }
            case "MediumMagic":
                if(((roll1 + player1.getMediumMagicAttack()) >= (roll2 + player2.getMagicBlock()) || isCrit) && player1.getTempMana() >= medium){
                    player1.setTempMana(player1.getTempMana() - medium);
                    return true;
                }
            case "HeavyMagic":
                if(((roll1 + player1.getHeavyMagicAttack()) >= (roll2 + player2.getMagicBlock()) || isCrit) && player1.getTempMana() >= heavy){
                    player1.setTempMana(player1.getTempMana() - heavy);
                    return true;
                }
        }
        switch (lmh) {
            case "LightPunch", "LightKick" -> player1.setTempStamina(player1.getTempStamina() - light);
            case "LightMagic" -> player1.setTempMana(player1.getMana() - light);
            case "MediumKick", "MediumPunch" -> player1.setTempStamina(player1.getTempStamina() - medium);
            case "MediumMagic" -> player1.setTempMana(player1.getTempMana() - medium);
            case "HeavyKick", "HeavyPunch" -> player1.setTempStamina(player1.getTempStamina() - heavy);
            case "HeavyMagic" -> player1.setTempMana(player1.getTempMana() - heavy);
        }
        return false;
    }

    //determines the attack type based on the player's fight style
    public static String getAttackType(Hero player){
        rollValue = roll(10);

        switch(player.getFightStyle()){
            case "Balance":
                rollValue = roll(9);
                if(rollValue < 4) {
                    attackType = "Punch";
                }else if(rollValue > 3 && rollValue < 7) {
                    attackType = "Kick";
                }else {
                    attackType = "Magic";
                }
                return attackType;

            case "Boxer":
                if(rollValue < 7) {
                    attackType = "Punch";
                }else if(rollValue < 9 && rollValue >= 7){
                    attackType = "Kick";
                } else {
                    attackType = "Magic";
                }
                return attackType;

            case "Kickboxer":
                if(rollValue < 7) {
                    attackType = "Kick";
                }else if(rollValue < 9 && rollValue >=7) {
                    attackType = "Punch";
                }else {
                    attackType = "Magic";
                }
                return attackType;

            case "Magician":
                if(rollValue < 7) {
                    attackType = "Magic";
                }else if(rollValue < 9 && rollValue >= 7) {
                    attackType = "Punch";
                }else {
                    attackType = "Kick";
                }
                return attackType;

            case "MMA":
                if(rollValue < 5) {
                    attackType = "Punch";
                }else if(rollValue > 4 && rollValue < 9) {
                    attackType = "Kick";
                }else {
                    attackType = "Magic";
                }
                return attackType;
            case "BattleMage":
                if(rollValue < 5) {
                    attackType = "Punch";
                }else if(rollValue > 4 && rollValue < 8) {
                    attackType = "Kick";
                }else {
                    attackType = "Magic";
                }
                return attackType;

        }
        return attackType;
    }

    //determine whether the attack is a light, medium, or heavy attack
    public static String determineLMH(Hero player){
        attackType = getAttackType(player);
        int lp = player.getLightPunchAttack();
        int mp = player.getMediumPunchAttack();
        int hp = player.getHeavyPunchAttack();
        int lk = player.getLightKickAttack();
        int mk = player.getMediumKickAttack();
        int hk = player.getHeavyKickAttack();
        int lm = player.getLightMagicAttack();
        int mm = player.getMediumMagicAttack();
        int hm = player.getHeavyMagicAttack();

        switch(attackType){
            case "Punch":
                rollValue = roll(lp + mp + hp);
                if(rollValue <= lp) {
                    lmh = "LightPunch";
                    return lmh;
                }
                else if(rollValue > lp && rollValue <= (lp+ mp)) {
                    lmh = "MediumPunch";
                    return lmh;
                }
                else if(rollValue > (lp + mp)) {
                    lmh = "HeavyPunch";
                    return lmh;
                }
            case "Kick":
                rollValue = roll(lk + mk + hk);
                if(rollValue <= lk) {
                    lmh = "LightKick";
                    return lmh;
                }
                else if(rollValue > lk && rollValue <= (lk+ mk)) {
                    lmh = "MediumKick";
                    return lmh;
                }
                else if(rollValue > (lk + mk)) {
                    lmh = "HeavyKick";
                    return lmh;
                }
            case "Magic":
                rollValue = roll(lm + mm + hm);
                if(rollValue <= lm) {
                    lmh = "LightMagic";
                    return lmh;
                }
                else if(rollValue > lm && rollValue <= (lm+ mm)) {
                    lmh = "MediumMagic";
                    return lmh;
                }
                else if(rollValue > (lm + mm)) {
                    lmh = "HeavyMagic";
                    return lmh;
                }

        }
        return lmh;
    }
    //gives an output based on lmh determination
    public static void getlmhOuput(String lmh){
        String lmhOutput;
        switch(lmh){
            case "LightPunch":
                lmhOutput = " does a quick jab!";
                System.out.println(lmhOutput);
                break;

            case "MediumPunch":
                lmhOutput = " goes for the haymaker!";
                System.out.println(lmhOutput);
                break;

            case "HeavyPunch":
                lmhOutput = " winds up with an uppercut!";
                System.out.println(lmhOutput);
                break;

            case "LightKick":
                lmhOutput = " does a snap kick";
                System.out.println(lmhOutput);
                break;

            case "MediumKick":
                lmhOutput = " goes for the roundhouse!";
                System.out.println(lmhOutput);
                break;

            case "HeavyKick":
                lmhOutput = " unleashes a powerful side kick";
                System.out.println(lmhOutput);
                break;

            case "LightMagic":
                lmhOutput = " throws a magic missile";
                System.out.println(lmhOutput);
                break;

            case "MediumMagic":
                lmhOutput = " charges up for a fireball!";
                System.out.println(lmhOutput);
                break;

            case "HeavyMagic":
                lmhOutput = " unleashes a beam of energy!";
                System.out.println(lmhOutput);

        }

    }

}
