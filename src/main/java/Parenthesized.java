class Parenthesized extends Primary {
    private Expression expression;

    Parenthesized() {
    }

    void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    long calculate() {
        return expression.calculate();
    }
}