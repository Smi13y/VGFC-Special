public class Character {
    private String name, fightStyle;
    private int lightPunchAttack, mediumPunchAttack, heavyPunchAttack;
    private int lightPunchDefense, mediumPunchDefense, heavyPunchDefense;
    private int lightKickAttack, mediumKickAttack, heavyKickAttack;
    private int lightKickDefense, mediumKickDefense, heavyKickDefense;
    private int lightMagicAttack, mediumMagicAttack, heavyMagicAttack;
    private int lightMagicDefense, mediumMagicDefense, heavyMagicDefense;
    private int dodgeBlock;
    private int[] statblock;
    private int[] frequency;
    private int hitPoints, tempHitpoints;

    public Character(String name, String fightStyle, int[] frequency, int[] statblock, int hitPoints, int dodgeBlock){
        this.name = name;
        this.fightStyle = fightStyle;
        this.hitPoints = hitPoints;
        this.tempHitpoints = hitPoints;
        this.frequency = frequency;

        lightPunchAttack = statblock[0];
        mediumPunchAttack = statblock[1];
        heavyPunchAttack = statblock[2];
        lightPunchDefense = statblock[3];
        mediumPunchDefense = statblock[4];
        heavyPunchDefense = statblock[5];

        lightKickAttack = statblock[6];
        mediumKickAttack = statblock[7];
        heavyKickAttack = statblock[8];
        lightKickDefense = statblock[9];
        mediumKickDefense = statblock[10];
        heavyKickDefense = statblock[11];

        lightMagicAttack = statblock[12];
        mediumMagicAttack = statblock[13];
        heavyMagicAttack = statblock[14];
        lightMagicDefense = statblock[15];
        mediumMagicDefense= statblock[16];
        heavyMagicDefense = statblock[17];

        this.dodgeBlock = dodgeBlock;

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

    public int getLightPunchDefense() {
        return lightPunchDefense;
    }

    public void setLightPunchDefense(int lightPunchDefense) {
        this.lightPunchDefense = lightPunchDefense;
    }

    public int getMediumPunchDefense() {
        return mediumPunchDefense;
    }

    public void setMediumPunchDefense(int mediumPunchDefense) {
        this.mediumPunchDefense = mediumPunchDefense;
    }

    public int getHeavyPunchDefense() {
        return heavyPunchDefense;
    }

    public void setHeavyPunchDefense(int heavyPunchDefense) {
        this.heavyPunchDefense = heavyPunchDefense;
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

    public int getLightKickDefense() {
        return lightKickDefense;
    }

    public void setLightKickDefense(int lightKickDefense) {
        this.lightKickDefense = lightKickDefense;
    }

    public int getMediumKickDefense() {
        return mediumKickDefense;
    }

    public void setMediumKickDefense(int mediumKickDefense) {
        this.mediumKickDefense = mediumKickDefense;
    }

    public int getHeavyKickDefense() {
        return heavyKickDefense;
    }

    public void setHeavyKickDefense(int heavyKickDefense) {
        this.heavyKickDefense = heavyKickDefense;
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

    public int getLightMagicDefense() {
        return lightMagicDefense;
    }

    public void setLightMagicDefense(int lightMagicDefense) {
        this.lightMagicDefense = lightMagicDefense;
    }

    public int getMediumMagicDefense() {
        return mediumMagicDefense;
    }

    public void setMediumMagicDefense(int mediumMagicDefense) {
        this.mediumMagicDefense = mediumMagicDefense;
    }

    public int getHeavyMagicDefense() {
        return heavyMagicDefense;
    }

    public void setHeavyMagicDefense(int heavyMagicDefense) {
        this.heavyMagicDefense = heavyMagicDefense;
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

    public int[] getFrequency() {
        return frequency;
    }

    public void setFrequency(int[] frequency) {
        this.frequency = frequency;
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
}
