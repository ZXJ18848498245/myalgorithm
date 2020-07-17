package dao;

public class Operation {
    private static int ADD = 1;
    private static int SUB = 2;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0 ;
        switch (operation){
            case "+": result = ADD;break;
            case "-": result = SUB;break;
            case "*": result = MUL;break;
            case "/": result = DIV;break;
        }
        return result;
    }
}
