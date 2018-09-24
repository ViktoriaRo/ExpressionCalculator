class Relation extends Expression {
    Relation(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        switch (op) {
            case less:
                return r1 < r2 ? 1 : 0;
            case greater:
                return r1 > r2 ? 1 : 0;
            case equal:
                return r1 == r2 ? 1 : 0;
        }
        return 0;
    }

    enum Opcode {less, greater, equal, none}

    private Opcode op;
    private Expression left, right;
}