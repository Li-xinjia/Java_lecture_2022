class Boy1 {

    // 実装１
    private String name;
    private int birthYear;

    Boy1() {
    }

    Boy1(String nm, int byr) {
        name = nm;
        birthYear = byr;
    }

    public String getName() {
        return name;
    }

    public int howold() {
        return (2019 - birthYear);    // 年齢を訊かれたら計算して返却
    }
}

class Boy2 {

    // 実装２
    private String name;
    private int birthYear;
    private int age;    // ageという変数を使用

    Boy2() {
    }

    Boy2(String nm, int byr) {
        name = nm;
        birthYear = byr;
        age = 2019 - birthYear;     // オブジェクト生成時に年齢を計算し、ageに設定
    }

    public String getName() {
        return name;
    }

    public int howold() {
        return (age);    // 年齢を訊かれたらageの値を返却
    }

}

/////// App ///////
class App {
    public static void main(String[] argv) {
        System.out.println("-----------Boy 1-----------");

        Boy1 o1 = new Boy1("Tom", 1999);

        System.out.println("name: " + o1.getName() + "  age: " + o1.howold());

        System.out.println("-----------Boy 2-----------");

        Boy2 o2 = new Boy2("Tom", 1999);

        System.out.println("name: " + o2.getName() + "  age: " + o2.howold());
    }
}