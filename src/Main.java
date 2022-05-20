import java.util.*;
public class Main {
    public static void main(String[] args){
        //Hero ryu = new Hero("Ryu", "Balance", 50, 50, 40, 5, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3,3,3,3}, 0 ,0 ,0, 0, 0);
        //Hero ken = new Hero("Ken", "Balance", 50, 50, 40, 5, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3,3,3,3}, 0 ,0 ,0, 0, 0);
        //ArrayList<Hero> players = new ArrayList<Hero>();
        //players.add(ryu);
        //players.add(ken);
        //Battle.match(ryu, ken, 180);

        Roster roster = new Roster();
        //roster.exportFile(players);
        roster.loadFromFile();
        Battle.match(roster.heroList.get(0), roster.heroList.get(1), 180);
        Battle.match(roster.heroList.get(0), roster.heroList.get(1), 180);
        Battle.match(roster.heroList.get(0), roster.heroList.get(1), 180);
        Battle.match(roster.heroList.get(0), roster.heroList.get(1), 180);
        Battle.match(roster.heroList.get(0), roster.heroList.get(1), 180);

        roster.exportFile(roster.heroList);

    }
}