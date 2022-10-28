public class Penguin extends Bird {
    static private int numPenguin = 0;

    Penguin(String Name) {
        super(Name);
        numPenguin++;
    }

    public static int getNum() {
        return numPenguin;
    }
}
