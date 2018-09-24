class Factor extends Expression {
    Factor(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        return r1 * r2;
    }

    private Expression left, right;
}