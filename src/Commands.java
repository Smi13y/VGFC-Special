public class Commands {
    private static int rollValue, lp, mp, hp, lk, mk, hk, lm, mm, hm;
    private static String attackType;
    private static String lmh, lmhOutput;
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
