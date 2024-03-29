// Abstract Expression
interface Expression {
    int interpret();
}

// Terminal Expression
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

// Non-terminal Expressions
class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class MultiplyExpression implements Expression {
    private Expression left;
    private Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

// Context
class Context {
    private Expression expression;

    public Context(Expression expression) {
        this.expression = expression;
    }

    public int evaluate() {
        return expression.interpret();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        // Expression: 2 + 3 * 4
        Expression expression = new AddExpression(
            new NumberExpression(2),
            new MultiplyExpression(
                new NumberExpression(3),
                new NumberExpression(4)
            )
        );

        Context context = new Context(expression);
        int result = context.evaluate();
        System.out.println("Result: " + result); // Output: Result: 14
    }
}