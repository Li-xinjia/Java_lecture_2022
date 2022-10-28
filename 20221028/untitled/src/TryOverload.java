public class TryOverload {
    private int valInt;
    private String valStr;
    private double valDouble;

    public double getValDouble() {
        return valDouble;
    }

    public int getValInt() {
        return valInt;
    }

    public String getValStr() {
        return valStr;
    }

    public void setValDouble(double valDouble) {
        this.valDouble = valDouble;
    }

    public void setValInt(int valInt) {
        this.valInt = valInt;
    }

    public void setValStr(String valStr) {
        this.valStr = valStr;
    }

    public void setValue(int val) {
        this.valInt = val;
    }

    public void setValue(double val) {
        this.valDouble = val;
    }

    public void setValue(String val) {
        this.valStr = val;
    }

    public void times(int val1, int val2) {
        System.out.println(val1 * val2);
    }

    public void times(String str, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public void times(int num, String str) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public void times(String str1, String str2) {
        System.out.println(str1 + str2);
    }

    public static void main(String[] argv) {
        TryOverload t = new TryOverload();

        t.setValue(2);
        System.out.println(t.getValInt());

        t.setValue("Hello");
        System.out.println(t.getValStr());

        t.setValue(22.22);
        System.out.println(t.getValDouble());

        t.times(3, 4);
        t.times("Happy", 3);
        t.times(4, "Birthday");
        t.times("Happy ", "Birthday!");
    }

}
