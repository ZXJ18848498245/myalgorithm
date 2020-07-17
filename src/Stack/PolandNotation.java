package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//后缀表达式计算
public class PolandNotation {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("12");
        s.add("5");
        s.add("-");
        s.add("3");
        s.add("7");
        s.add("*");
        s.add("+");


        System.out.println(calculate(s));
    }
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item :ls){
            //使用正则表达是取出数
            if (item.matches("\\d+")) {//匹配是多位数
                //入栈
                stack.push(item);
            }else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item){
                    case "+": res = num1+num2;break;
                    case "-": res = num2-num1;break;
                    case "*": res = num1*num2;break;
                    case "/": res = num2/num1;break;
                    default: throw new RuntimeException("字符有错");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
