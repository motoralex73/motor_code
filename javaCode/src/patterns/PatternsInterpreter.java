package patterns;

import java.util.Stack;

//Паттерн Интерпритатор, паттерн парсинга строки например, любое выражение разбивается на экспрешены
public class PatternsInterpreter {

    interface Expression {
        int inter(Expression context);
    }

    static class Number implements Expression{
        int number;
        public Number(int number) {
            this.number = number;
        }
        @Override
        public int inter(Expression context) {
            return number;
        }
    }

    static class Plus implements Expression {
        Expression exLeft, exRight;
        public Plus(Expression exLeft, Expression exRight) {
            this.exLeft = exLeft;
            this.exRight = exRight;
        }
        @Override
        public int inter(Expression context) {
            return exLeft.inter(context) + exRight.inter(context);
        }
    }

    static class Minus extends Plus {
        public Minus(Expression exLeft, Expression exRight) {
            super(exLeft, exRight);
        }
        @Override
        public int inter(Expression context) {
            return exLeft.inter(context) - exRight.inter(context);
        }
    }

    static class Evaluate implements Expression {
        Expression evaluate;
        public Evaluate(String expression) {
            Stack<Expression> expressions = new Stack<>();
            String expressionRevers = new StringBuilder(expression).reverse().toString();
            for (String s : expressionRevers.split("\\D")) {
                expressions.push(new Number(Integer.parseInt(s)));
            }
            for (String s : expression.split("\\d")) {
                if (s.equals("+")) {
                    expressions.push(new Plus(expressions.pop(), expressions.pop()));
                }
                else if (s.equals("-")) {
                    expressions.push(new Minus(expressions.pop(), expressions.pop()));
                }
            }
            evaluate = expressions.pop();
        }
        @Override
        public int inter(Expression context) {
            return evaluate.inter(context);
        }
    }

    public static void main(String[] args) {
        String expression = "1+2+3-4";
        Expression evaluator = new Evaluate(expression);
        System.out.println(evaluator.inter(evaluator));
    }
}
