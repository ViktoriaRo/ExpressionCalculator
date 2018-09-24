class Number extends Primary {
    private long val;

    Number(long val) {
        this.val = val;
    }

    @Override
    long calculate() {
        return val;
    }
}