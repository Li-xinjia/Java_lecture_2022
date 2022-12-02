public class CalcCtrl {
    private CalcModel cm;
    CalcCtrl(){
        cm = new CalcModel();
    }
    String Calc(String mode ,String a,String b){
        int a_int,b_int;
        try {
            a_int = Integer.parseInt(a);
            b_int = Integer.parseInt(b);
        }catch(NumberFormatException e){
            return "Error";
        }
        
        switch (mode){
            case "+":
                return String.valueOf(cm.plus(a_int,b_int));
            case "-":
                return String.valueOf(cm.minus(a_int,b_int));
            case "*":
                return String.valueOf(cm.multi(a_int,b_int));
            case "/":
                return String.valueOf(cm.divide(a_int,b_int));
            default:
                return "Error";
        }
    }
}
