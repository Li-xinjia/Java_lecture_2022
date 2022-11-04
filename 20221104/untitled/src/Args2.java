class Args2 {
    public static void main(String[] args) {
        String valStr;
        int valInt;
        double valDouble;

        int count = 0;

        for (String i : args) {
            System.out.println("args[" + count + "] = " + i);
            if (i.matches("\\d+\\.\\d+")){
                valDouble = Double.parseDouble(i);
                System.out.println("valDouble = " + valDouble);
            }else if(i.matches("^[0-9]*$")){
                valInt = Integer.parseInt(i);
                System.out.println("valInt = " + valInt);
            }else {
                valStr = i;
                System.out.println("valStr = " + valStr);
            }
            count ++;
        }
    }
}