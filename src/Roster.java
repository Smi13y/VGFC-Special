import java.util.*;
import java.io.*;
//A class meant for building and populating a roster
public class Roster {

    ArrayList<Hero> heroList;

    public Roster () {
        heroList = new ArrayList<Hero>();
    }
    public void loadFromFile() {

        Scanner inFS = null;
        FileInputStream fileByteStream = null;
        int hitPoints, stamina, mana, dodgeBlock, fights, win, loss, draw, level, exp;
        String name, fightStyle;
        int[] statBlock = new int[12];
        boolean alive;

        try{
            // open the File and set delimiters
            fileByteStream = new FileInputStream("Roster.txt");
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter("[\s\n]+");


            // continue while there is more data to read
            while(inFS.hasNext()) {

                // read four data elements
                name = inFS.next();
                fightStyle = inFS.next();
                hitPoints = inFS.nextInt();
                stamina = inFS.nextInt();
                mana = inFS.nextInt();
                dodgeBlock = inFS.nextInt();

                statBlock[0] = inFS.nextInt();
                statBlock[1] = inFS.nextInt();
                statBlock[2] = inFS.nextInt();
                statBlock[3] = inFS.nextInt();
                statBlock[4] = inFS.nextInt();
                statBlock[5] = inFS.nextInt();
                statBlock[6] = inFS.nextInt();
                statBlock[7] = inFS.nextInt();
                statBlock[8] = inFS.nextInt();
                statBlock[9] = inFS.nextInt();
                statBlock[10] = inFS.nextInt();
                statBlock[11] = inFS.nextInt();

                fights = inFS.nextInt();
                win = inFS.nextInt();
                draw = inFS.nextInt();
                loss = inFS.nextInt();
                level = inFS.nextInt();
                exp = inFS.nextInt();

                Hero hero = new Hero(name, fightStyle, hitPoints, stamina, mana, dodgeBlock, statBlock, fights, win, draw, loss, level, exp);
                //TO DO: instantiate an object of the Hero class
                heroList.add(hero);
                //TO DO: add object to the collection (heroList)
            }
            fileByteStream.close();

            // error while reading the file
        }catch(IOException error1) {
            System.out.println("Oops! Error related to: Character.dat" );
        }
    }

    public void exportFile(ArrayList<Hero> heroList){
        FileOutputStream fileStream = null;
        PrintWriter outFS = null;
        try {
            // Try to open file
            fileStream = new FileOutputStream("Roster.txt");
            outFS = new PrintWriter(fileStream);

            // Arriving here implies that the file can now be written
            // to, otherwise an exception would have been thrown.
            for(Hero c : heroList){
                outFS.print(c.getName() + " " + c.getFightStyle() + " "
                        + c.getHitPoints() + " " + c.getStamina()
                        + " " + c.getMana() + " " + c.getDodgeBlock()
                        + " " + c.getLightPunchAttack() + " " + c.getMediumPunchAttack() + " " + c.getHeavyPunchAttack() + " " + c.getPunchBlock()
                        + " " + c.getLightKickAttack() + " " + c.getMediumKickAttack() + " " + c.getHeavyKickAttack() + " " + c.getKickBlock()
                        + " " + c.getLightMagicAttack() + " " + c.getMediumMagicAttack() + " " + c.getHeavyMagicAttack() + " " + c.getMagicBlock()
                        + " " + c.getFights() + " " + c.getWin() + " " + c.getDraw() + " " + c.getLoss()
                        + " " + c.getLevel() + " " + c.getExp() + "\n");
            }

            // Done with file, so try to close
            // Note that close() may throw an IOException on failure
            outFS.close();
        } catch(IOException error1){
            System.out.println("Oops! Error related to: Character.dat" );
        }
    }


}
