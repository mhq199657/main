package seedu.address.logic.parser;

public class FilterRange<E> {
    private boolean isRange;
    private E lowValue;
    private E highValue;
    private E exactValue;

    FilterRange(E exactValue) {
        this.isRange = false;
        this.lowValue = null;
        this.highValue = null;
        this.exactValue = exactValue;
    }

    FilterRange(E lowValue, E highValue) {
        this.isRange = true;
        this.lowValue = lowValue;
        this.highValue = highValue;
        this.exactValue = null;
    }

    public boolean isRange() {
        return isRange;
    }

    public E getExactValue() {
        assert(!isRange);
        return exactValue;
    }

    public E getLowValue() {
        assert(isRange);
        return lowValue;
    }

    public E getHighValue() {
        assert(isRange);
        return highValue;
    }
}