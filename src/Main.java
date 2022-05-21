import java.util.*;
public class Main {
    public static void main(String[] args){
       /* String[] namesList = {"ShovelFace", "MrSirLordOfCum", "Sammich", "CaptainAnarchy", "Donald", "MargaretThatcher", "TukTuk", "SusanAAnthony"};
       String name;
        ArrayList<Hero> players = new ArrayList<Hero>();


        for(int i = 0; i < namesList.length; i++){
            name = namesList[i];
            Hero newHero = new Hero(name);
            players.add(newHero);
        }*/

        Roster roster = new Roster();
        //roster.exportFileCSV(players);
        //roster.exportFile(players);
        roster.loadFromFile();
        /*int m = 0;
        while(m < 10) {
            Collections.shuffle(roster.heroList);
            for (int i = 0; i < ((roster.heroList.size() + 1) / 2); i++) {
                Battle.match(roster.heroList.get(i), roster.heroList.get(roster.heroList.size() - (i + 1)), 180);
            }
            m++;
            roster.exportFile(roster.heroList);
        }*/

        for(Hero h: roster.heroList){

            System.out.println("==========");
            System.out.println(h);
            System.out.println("==========");

        }

    }
}