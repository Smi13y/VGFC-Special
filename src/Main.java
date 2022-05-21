import java.util.*;
public class Main {
    public static void main(String[] args){
        String[] namesList = {"Scorpion" , "Sub-Zero", "LiuKang", "KungLao", "Raiden", "SonyaBlade", "JohnnyCage",
                "Jax", "Baraka", "Kitana", "Jade", "Mileena", "TsangTsung", "ShaoKhan", "Goro", "Sheeva", "Sindel",
                "Stryker", "Kintaro", "Kano", "NoobSaibot", "Nitara", "Ermac", "Kabal", "CassieCage", "D'Vorha",
                "QuanChi", "Kenshi", "Cyrax", "KotalKhan", "ErronBlack", "Geras", "Shinnok", "NightWolf", "Bo'RaiCho",
                "Cetrion", "Blaze", "Skarlet", "Onaga", "Motaro", "Daegon", "Smoke", "JacquiBriggs", "Reptile",
                "Tremor", "Ashrah", "Fujin", "Havik", "Chameleon", "Khanmeleon", "Rain", "Sektor", "Frost", "Sareena",
                "Jarek", "Kai", "Reiko", "Tanya", "Drahmin", "HsuHao", "LiMei", "Mavado", "Moloch", "Dairou", "Darrius",
                "Hotaru", "Kira", "Kobra", "Shujinko", "Daegon", "Taven", "FerraTor", "KungJin", "Takeda", "Triborg",
                "Kollector", "Kronika"};
        String name;
        ArrayList<Hero> players = new ArrayList<Hero>();


        for(int i = 0; i < namesList.length - 1; i++){
            name = namesList[i];
            Hero newHero = new Hero(name);
            players.add(newHero);
        }

        Roster roster = new Roster();
        roster.exportFile(players);
        roster.loadFromFile();
        int m = 0;
        while(m < 10) {
            Collections.shuffle(roster.heroList);
            for (int i = 0; i < ((roster.heroList.size() + 1) / 2); i++) {
                Battle.match(roster.heroList.get(i), roster.heroList.get(roster.heroList.size() - (i + 1)), 180);
            }
            m++;
        }
        roster.exportFile(roster.heroList);

    }
}