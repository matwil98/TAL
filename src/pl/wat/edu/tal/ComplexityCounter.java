package pl.wat.edu.tal;

public class ComplexityCounter {
    private int counterOperation;


    public ComplexityCounter(int operation){
        this.counterOperation +=operation;
    }

    public int getCounterOperation() {
        return counterOperation;
    }

    public void setCounterOperation(int counterOperation) {
        this.counterOperation = counterOperation;
    }

    @Override
    public String toString() {
        return "ComplexityCounter{" +
                "counterOperation=" + counterOperation +
                '}';
    }
}
