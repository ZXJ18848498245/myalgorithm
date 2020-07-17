package Stack;

import dao.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class parseSuffixList {
    public static List<String> parseSuffixExpreesionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 =new Stack<>();//符号栈
        List<String> s2 = new ArrayList<>();//储存中间结果的栈

        for(String item: ls ){
            //如果是一个数，加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将左括号消除
            }else{
                //当item的优先级小于等于s1栈顶运算符弹出并加入到s2,再次比较
                while (s1.size()!=0&& Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }

        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

 }
