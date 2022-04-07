public class Commands {
    private static int rollValue, lp, mp, hp, lk, mk, hk, lm, mm, hm;
    private static Character player;
    private static String attackType;
    private static String lmh;

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

}
