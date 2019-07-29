package com.github.oahnus.datastructure.StackAndQueue.EvaluationOfExpression;

import java.util.Stack;

/**
 * Created by jackstrom on 2016/4/24.
 */
public class Expression {
    private String fixExpression;
    private String postfixExpression;
    private Stack<Character> stack;

    public Expression(String fixExpression) {
        this.fixExpression = fixExpression;
        postfixExpression = "";
        stack = new Stack<>();
    }

    public String getPostfixExpression(){
        changeFixExpressionToPostfixExpression();
        return postfixExpression;
    }

    private void changeFixExpressionToPostfixExpression(){
        postfixExpression = "";
        char c = ' ';
        for(int i=0;i<fixExpression.length();i++){
            c = fixExpression.charAt(i);
            if(Character.isDigit(c)){
                postfixExpression += c;
            }
            else{
                char top;
                if(stack.size()==0){
                    stack.push(c);
                    continue;
                }
                switch (c){
                    case '+':
                    case '-':
                        top = stack.peek();
                        if(top=='*'||top=='/'){
                            postfixExpression += stack.pop();
                            stack.push(c);
                        }else{
                            stack.push(c);
                        }
                        break;
                    case '*':
                    case '/':
                        top = stack.peek();
                        if(top == '*'||top == '/'){
                            postfixExpression += stack.pop();
                            stack.push(c);
                        }else{
                            stack.push(c);
                        }
                        break;
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        top = stack.pop();
                        while(top!='('){
                            postfixExpression += top;
                            top = stack.pop();
                        }
                        break;
                }
            }
        }
        while(stack.size()!=0){
            postfixExpression += stack.pop();
        }
    }
}
