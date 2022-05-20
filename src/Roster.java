import java.util.*;
import java.io.*;
//A class meant for building and populating a roster
public class Roster {

    //TODO create generateCharacter()
    //TODO create generateRoster()
    //TODO create importRoster()

    ArrayList<Hero> heroList;
    public Roster () {
        heroList = new ArrayList<Hero>();
    }
    public void loadFromFile() {

        Scanner inFS = null;
        FileInputStream fileByteStream = null;

        try{
            // open the File and set delimiters
            fileByteStream = new FileInputStream("Roster.txt");
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter("[,\r\n]+");
            inFS.nextLine();

            // continue while there is more data to read
            while(inFS.hasNext()) {

                // read four data elements
                String name = inFS.next();

                String fightStyle = inFS.next();
                int hitPoints = inFS.nextInt();
                int stamina = inFS.nextInt();
                int mana = inFS.nextInt();
                int dodgeBlock = inFS.nextInt();
                int[] statBlock = new int[12];
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

                int win = inFS.nextInt();
                int draw = inFS.nextInt();
                int loss = inFS.nextInt();

                Hero hero = new Hero(name, fightStyle, hitPoints, stamina, mana, dodgeBlock, statBlock, win, draw, loss);
                //TO DO: instantiate an object of the Character class
                heroList.add(hero);
                //TO DO: add object to the collection (characterList)
            }
            fileByteStream.close();

            // error while reading the file
        }catch(IOException error1) {
            System.out.println("Oops! Error related to: Character.dat" );
        }
    }

    public void exportFile(ArrayList characterList){
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
                        + " " + c.getWin() + " " + c.getDraw() + " " + c.getLoss());
            }

            // Done with file, so try to close
            // Note that close() may throw an IOException on failure
            outFS.close();
        } catch(IOException error1){
            System.out.println("Oops! Error related to: Character.dat" );
        }
    }
}
