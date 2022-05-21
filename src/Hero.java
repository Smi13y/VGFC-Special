public class Hero {
    private String name, fightStyle;
    private int lightPunchAttack, mediumPunchAttack, heavyPunchAttack, punchBlock;
    private int lightKickAttack, mediumKickAttack, heavyKickAttack, kickBlock;
    private int lightMagicAttack, mediumMagicAttack, heavyMagicAttack, magicBlock;
    private int fights, win, draw, loss;
    private int level, exp;
    private int dodgeBlock;
    private int[] statblock;
    private int hitPoints, tempHitpoints;
    private int stamina, tempStamina;
    private int mana, tempMana;
    private String[] styleList = {" ", "Balance", "Boxer", "Kickboxer", "Magician", "MMA", "BattleMage"};
    //removed titles for now

    public Hero(String name){
        this.name = name;
        this.fightStyle = styleList[Commands.roll(styleList.length)];

        this.hitPoints = 30 + Commands.roll(25);
        this.tempHitpoints = hitPoints;

        this.stamina = 20 + Commands.roll(20);
        this.tempStamina = stamina;

        this.mana = 20 + Commands.roll(20);
        this.tempMana = mana;

        this.dodgeBlock = Commands.roll(10);

        this.lightPunchAttack = Commands.roll(5);
        this.mediumPunchAttack = Commands.roll(5);
        this.heavyPunchAttack = Commands.roll(5);
        this.punchBlock = Commands.roll(5);

        this.lightKickAttack = Commands.roll(5);
        this.mediumKickAttack = Commands.roll(5);
        this.heavyKickAttack = Commands.roll(5);
        this.kickBlock = Commands.roll(5);

        this.lightMagicAttack = Commands.roll(5);
        this.mediumMagicAttack = Commands.roll(5);
        this.heavyMagicAttack = Commands.roll(5);
        this.magicBlock = Commands.roll(5);

        this.fights = 0;
        this.win = 0;
        this.draw = 0;
        this.loss = 0;

        this.level = 1;
        this.exp = 0;
    }

    public Hero(String name, String fightStyle, int hitPoints, int stamina, int mana, int dodgeBlock, int[] statblock, int fights, int win, int draw, int loss, int level, int exp) {
        this.name = name;
        this.fightStyle = fightStyle;
        this.hitPoints = hitPoints;
        this.stamina = stamina;
        this.mana = mana;
        this.tempHitpoints = hitPoints;
        this.tempStamina = stamina;
        this.tempMana = mana;
        this.dodgeBlock = dodgeBlock;

        lightPunchAttack = statblock[0];
        mediumPunchAttack = statblock[1];
        heavyPunchAttack = statblock[2];
        punchBlock = statblock[3];

        lightKickAttack = statblock[4];
        mediumKickAttack = statblock[5];
        heavyKickAttack = statblock[6];
        kickBlock = statblock[7];

        lightMagicAttack = statblock[8];
        mediumMagicAttack = statblock[9];
        heavyMagicAttack = statblock[10];
        magicBlock = statblock[11];

        this.fights = fights;
        this.win = win;
        this.draw = draw;
        this.loss = loss;

        this.level = 1;
        this.exp = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFightStyle() {
        return fightStyle;
    }

    public void setFightStyle(String fightStyle) {
        this.fightStyle = fightStyle;
    }

    public int getLightPunchAttack() {
        return lightPunchAttack;
    }

    public void setLightPunchAttack(int lightPunchAttack) {
        this.lightPunchAttack = lightPunchAttack;
    }

    public int getMediumPunchAttack() {
        return mediumPunchAttack;
    }

    public void setMediumPunchAttack(int mediumPunchAttack) {
        this.mediumPunchAttack = mediumPunchAttack;
    }

    public int getHeavyPunchAttack() {
        return heavyPunchAttack;
    }

    public void setHeavyPunchAttack(int heavyPunchAttack) {
        this.heavyPunchAttack = heavyPunchAttack;
    }

    public int getPunchBlock() {
        return punchBlock;
    }

    public void setPunchBlock(int punchBlock) {
        this.punchBlock = punchBlock;
    }

    public int getLightKickAttack() {
        return lightKickAttack;
    }

    public void setLightKickAttack(int lightKickAttack) {
        this.lightKickAttack = lightKickAttack;
    }

    public int getMediumKickAttack() {
        return mediumKickAttack;
    }

    public void setMediumKickAttack(int mediumKickAttack) {
        this.mediumKickAttack = mediumKickAttack;
    }

    public int getHeavyKickAttack() {
        return heavyKickAttack;
    }

    public void setHeavyKickAttack(int heavyKickAttack) {
        this.heavyKickAttack = heavyKickAttack;
    }

    public int getKickBlock() {
        return kickBlock;
    }

    public void setKickBlock(int kickBlock) {
        this.kickBlock = kickBlock;
    }

    public int getLightMagicAttack() {
        return lightMagicAttack;
    }

    public void setLightMagicAttack(int lightMagicAttack) {
        this.lightMagicAttack = lightMagicAttack;
    }

    public int getMediumMagicAttack() {
        return mediumMagicAttack;
    }

    public void setMediumMagicAttack(int mediumMagicAttack) {
        this.mediumMagicAttack = mediumMagicAttack;
    }

    public int getHeavyMagicAttack() {
        return heavyMagicAttack;
    }

    public void setHeavyMagicAttack(int heavyMagicAttack) {
        this.heavyMagicAttack = heavyMagicAttack;
    }

    public int getMagicBlock() {
        return magicBlock;
    }

    public void setMagicBlock(int magicBlock) {
        this.magicBlock = magicBlock;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getDodgeBlock() {
        return dodgeBlock;
    }

    public void setDodgeBlock(int dodgeBlock) {
        this.dodgeBlock = dodgeBlock;
    }

    public int[] getStatblock() {
        return statblock;
    }

    public void setStatblock(int[] statblock) {
        this.statblock = statblock;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getTempHitpoints() {
        return tempHitpoints;
    }

    public void setTempHitpoints(int tempHitpoints) {
        this.tempHitpoints = tempHitpoints;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getTempStamina() {
        return tempStamina;
    }

    public void setTempStamina(int tempStamina) {
        this.tempStamina = tempStamina;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getTempMana() {
        return tempMana;
    }

    public void setTempMana(int tempMana) {
        this.tempMana = tempMana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getFights() {
        return fights;
    }

    public void setFights(int fights) {
        this.fights = fights;
    }

    public String toString(){
        return "Name: " + name + "\nFight Style: " + fightStyle + "\nHP: " + hitPoints + "\tStamina: " + stamina + "\tMana: " + mana +
                "\nPunch: " + lightPunchAttack + "-" + mediumPunchAttack + "-" + heavyPunchAttack + "-" + punchBlock +
                "\nKick: " + lightKickAttack + "-" + mediumKickAttack + "-" + heavyKickAttack + "-" + kickBlock +
                "\nMagic: " + lightMagicAttack + "-" + mediumMagicAttack + "-" + heavyMagicAttack + "-" + magicBlock +
                "\nDodge/Block: " + dodgeBlock +
                "\nLevel: " + level + " Exp: " + exp +
                "\nFights: " + fights +
                "\nW/D/L: " + win + "-" + draw + "-" + loss;

    }
}
