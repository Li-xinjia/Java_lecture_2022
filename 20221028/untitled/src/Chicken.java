public class Chicken extends Bird {
    static private int numChicken = 0;

    Chicken(String Name) {
        super(Name);
        numChicken++;
    }

    public static int getNum() {
        return numChicken;
    }
}
