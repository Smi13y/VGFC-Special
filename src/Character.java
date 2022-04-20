import java.lang.reflect.Array;
import java.util.ArrayList;

public class Character {
    private String name, fightStyle;
    private int lightPunchAttack, mediumPunchAttack, heavyPunchAttack, punchBlock;
    private int lightKickAttack, mediumKickAttack, heavyKickAttack, kickBlock;
    private int lightMagicAttack, mediumMagicAttack, heavyMagicAttack, magicBlock;
    private int win, draw, loss;
    private int dodgeBlock;
    private int[] statblock;
    private int[] frequency;
    private int hitPoints, tempHitpoints;
    private int stamina, tempStamina;
    private int mana, tempMana;
    private ArrayList<String> titles = new ArrayList<String>();

    public Character(String name, String fightStyle, int hitPoints, int stamina, int mana,int dodgeBlock, int[] frequency, int[] statblock, ArrayList<String> titles) {
        this.name = name;
        this.fightStyle = fightStyle;
        this.hitPoints = hitPoints;
        this.stamina = stamina;
        this.mana = mana;
        this.tempHitpoints = hitPoints;
        this.tempStamina = stamina;
        this.tempMana = mana;
        this.dodgeBlock = dodgeBlock;
        this.titles = titles;
        this.frequency = frequency;

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

        win = 0;
        draw = 0;
        loss = 0;

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

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public String toString(){
        return "Name: " + name + "\nFight Style: " + fightStyle + "\nHP: " + hitPoints + "\tStamina: " + stamina + "\tMana: " + mana +
                "\nPunch: " + lightPunchAttack + "-" + mediumPunchAttack + "-" + heavyPunchAttack + "-" + punchBlock +
                "\nKick: " + lightKickAttack + "-" + mediumKickAttack + "-" + heavyKickAttack + "-" + kickBlock +
                "\nMagic: " + lightMagicAttack + "-" + mediumMagicAttack + "-" + heavyMagicAttack + "-" + magicBlock +
                "\nDodge/Block: " + dodgeBlock +
                "\nW/D/L: " + win + "-" + draw + "-" + loss +
                "\nTitles: " + titles;

    }
}
