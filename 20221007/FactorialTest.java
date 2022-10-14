public class FactorialTest {
    public static void main(String[] args) {
        Factorial[] f = new Factorial[10];
        f[0] = new Factorial();
        for (int i = 0; i < 10; i++) {
            f[i] = new Factorial();
            f[i].setNum(i);
        }
        f[0].setFact(1);
        for (int j = 1; j < 10; j++) {
            f[j].setFact(f[j - 1].getFact() * f[j].getNum());
        }
        for (Factorial i : f) {
            System.out.println(i.getNum() + "! = " + i.getFact());
        }
    }
}
