package pl.wat.edu.tal;

public class ComplexityCounter {
    private int counterOperation = 0;
    private int counterOfInt = 0;

    public void increaseCounterOfOperation(int value){
        this.counterOperation += value;
    }
    public int getCounterOperation() {
        return counterOperation;
    }

    public void setCounterOperation(int counterOperation) {
        this.counterOperation = counterOperation;
    }

    public int countInt(int numberOfInt){
       this.counterOfInt += numberOfInt;
       return counterOfInt;
    }

    public int getCounterOfInt() {
        return counterOfInt;
    }

    @Override
    public String toString() {
        return "ComplexityCounter{" +
                "counterOperation=" + counterOperation +
                '}';
    }
}
