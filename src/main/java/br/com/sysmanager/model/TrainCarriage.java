package br.com.sysmanager.model;

public class TrainCarriage {

    public int number;
    public String insertionSide;

    public TrainCarriage(int number, String insertionSide) {
        this.number = number;
        this.insertionSide = insertionSide;
    }

    public int getNumber() {
        return number;
    }

    public String getInsertionSide() {
        return insertionSide;
    }

    public void setInsertionSide(String insertionSide) {
        this.insertionSide = insertionSide;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
