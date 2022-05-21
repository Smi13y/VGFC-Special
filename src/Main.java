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
                "Kollector", "Kronika","Ryu", "Ken", "Chun-Li", "Guile", "E.Honda", "Dhalsim", "Blanka", "Zangief",
                "Balrog", "Vega", "Sagat", "M.Bison", "Cammy", "FeiLong", "T.Hawk", "DeeJay", "Akuma", "ViolentKen",
                "Charlie", "Rose", "Dan", "Birdie", "Adon", "Guy", "Sodom", "Sakura", "Gen", "Rolento", "EvilRyu",
                "ShinAkuma", "R.Mika", "Karin", "Juli", "Juni", "Cody", "Eagle", "Maki", "Ingrid", "Alex", "Yun",
                "Yang", "Dudley", "Ibuki", "Elena", "Oro", "Sean", "Necro", "Gil", "Hugo", "Urien", "Makoto", "Remy",
                "Twelve", "Q", "C.Viper", "Abel", "ElFuerte", "Rufus", "Seth", "Gouken", "Juri", "Hakan", "Oni", "Poison",
                "Decapre", "Necalli", "Rashid", "Laura", "F.A.N.G.", "Kolin", "Ed", "Abigail", "Menat", "Zeku", "Falke", "G",
                "Kage", "Lucia", "Eleven", "Akira", "Luke", "Alex", "AlisaBosconovitch", "AncientOgre", "Angel", "AnnaWilliams",
                "ArmorKing", "ArmorKingII", "AsukaKazama", "Azazel", "BaekDooSan", "Bet-rto", "Billy", "BoMontanna", "Bonner",
                "BruceIrvin", "BryanFury", "BryceAdams", "CristieMonteiro", "ClaudioSerafino", "Combot", "CraigMarduk", "Crow",
                "Denslow", "DevilJin", "DevilKazumi", "DevilKazuya", "DoctorAbel", "DoctorBosconovitch", "EddyGordo", "EdgarGrant",
                "Eliza", "EmilieDeRochefort", "EmmaKliesen", "EnriqueOrtega", "Fahkumram", "FengWei", "ForestLAw", "Ganmi-chan",
                "Ganryu", "GeeseHOward", "Gigas", "Gon", "HachimanMishima", "HeihachiMishima", "Hwoarang", "Isaak", "Jack", "Jane",
                "Jaycee", "JeffSlater", "JinKazama", "JinpachiMishima", "JosieRizal", "JohnDoe", "JosieRizal", "JuliaChang",
                "JunKazama", "Kara", "KatarinaAlves", "KazumiMishima", "KazyuaMishima", "King", "KingII", "Kinjin", "Kuma",
                "KumaII", "Kunimitsu", "KunimitsuII", "LanaLei", "LarsAlexandersson", "LeeChaolan", "LeiWulong", "LeoKliesen",
                "LeroySmith", "LidiaSobieska", "LingXiaoyu", "LuckyChloe", "LukasHayes", "MarshallLaw", "MasterRaven", "MichelleChang",
                "MigueCabelleroRojo", "MiharuHirano", "Mokujin", "NANCY-MI847J", "NEganSmith", "NinaWilliams", "NoctisLucisCaelum",
                "Olivia", "Panda", "PaulPheonix", "ProfessorT", "Raven", "Revenant", "RichardWIlliams", "Rippers", "RobertRichards",
                "Roger", "RogerJr.", "Roperto", "Ruby", "Sake", "Sebastian", "SergeiDragunov", "Shaheen", "ShinKamiya", "SlimBob",
                "SeveFox", "Sugar", "Tesujin", "TigerJackson", "TigerMiyagi", "Tougou"};
       /* String name;
        ArrayList<Hero> players = new ArrayList<Hero>();


        for(int i = 0; i < namesList.length - 1; i++){
            name = namesList[i];
            Hero newHero = new Hero(name);
            players.add(newHero);
        }*/

        Roster roster = new Roster();
        //roster.exportFile(players);
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