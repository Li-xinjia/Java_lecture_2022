class Args3{
    public static void main(String[] args){
        String valStr;
        int count = 0;
        int valInt;
        double valDouble;
        for (String i : args) {
            System.out.println("args[" + count + "] = " + i);
            count++;

            try {
                valInt = Integer.parseInt(i);
                System.out.println("valInt = " + valInt);
                continue;
            }catch(NumberFormatException e){}
            try {
                valDouble = Double.parseDouble(i);
                System.out.println("valDouble = " + valDouble);
                continue;
            }catch(NumberFormatException e){}

            valStr = i;
            System.out.println("valStr = " + valStr);
        }
    }
}