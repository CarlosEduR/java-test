package br.com.sysmanager;

import java.util.ArrayList;
import java.util.List;

public class RemovalPossibilities {
    List<Integer> leftPossibility;
    List<Integer> rightPossibility;

    public RemovalPossibilities(){
        leftPossibility = new ArrayList<>();
        rightPossibility = new ArrayList<>();
    }

    public List<Integer> getLeftPossibility() {
        return leftPossibility;
    }

    public void setLeftPossibility(List<Integer> leftPossibility) {
        this.leftPossibility = leftPossibility;
    }

    public List<Integer> getRightPossibility() {
        return rightPossibility;
    }

    public void setRightPossibility(List<Integer> rightPossibility) {
        this.rightPossibility = rightPossibility;
    }
}
