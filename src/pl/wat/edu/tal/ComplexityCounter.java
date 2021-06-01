package pl.wat.edu.tal;

public class ComplexityCounter {
    private int counterOperation = 0;

    public ComplexityCounter(int value) {
        this.counterOperation += value;
    }

    public ComplexityCounter() {

    }

    public void increaseCounterOfOperation(int value) {
        this.counterOperation += value;
    }

    public int getCounterOperation() {
        return counterOperation;
    }


    @Override
    public String toString() {
        return "ComplexityCounter{" +
                "counterOperation=" + counterOperation +
                '}';
    }
}
