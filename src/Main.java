public class Main {
    public static void main(String[] args){
        Character ryu = new Character("Ryu", "Balance", 50, 50, 40, 5, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3,3,3,3});
        Character ken = new Character("Ken", "Balance", 50, 50, 40, 5, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3,3,3,3});
        Battle.match(ryu,ken, 180);
    }
}