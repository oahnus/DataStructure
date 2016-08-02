package StackAndQueue.EvaluationOfExpression;

import java.util.Stack;

/**
 * Created by jackstrom on 2016/4/24.
 */
public class CalculateValue {
    private String expression;
    private Stack<Integer> stack;

    public CalculateValue(String expression) {
        this.expression = expression;
        stack = new Stack<>();
    }

    public double calculate(){
        double retVal = 0;

        try{
            for(int i=0;i<expression.length();i++){
                char ch = expression.charAt(i);
                if(Character.isDigit(ch)){
                    stack.push(Integer.valueOf(ch-48));
                }else{
                    int secondNum = stack.pop();
                    int firstNum = stack.pop();
                    switch(ch){
                        case '+':
                            stack.push(firstNum+secondNum);
                            break;
                        case '-':
                            stack.push(firstNum-secondNum);
                            break;
                        case '*':
                            stack.push(firstNum*secondNum);
                            break;
                        case '/':
                            stack.push(firstNum/secondNum);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            retVal = stack.pop();
        }
        return retVal;
    }
}
