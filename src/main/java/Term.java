class Term extends Expression {
    Term(OpCode op, Expression left, Expression right) {
        this.op = op;
        this.right = right;
        this.left = left;
    }

    @Override
    long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        switch (op) {
            case plus:
                return r1 + r2;
            case minus:
                return r1 - r2;
        }
        return 0;
    }

    enum OpCode {plus, minus, none}

    private OpCode op;
    private Expression right, left;
}