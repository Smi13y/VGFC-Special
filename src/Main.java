public class Main {
    public static void main(String[] args){
        Hero ryu = new Hero("Ryu", "Balance", 50, 50, 40, 5, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3,3,3,3}, 0 ,0 ,0);
        Hero ken = new Hero("Ken", "Balance", 50, 50, 40, 5, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3,3,3,3}, 0 ,0 ,0);
        Battle.match(ryu,ken, 180);
    }
}