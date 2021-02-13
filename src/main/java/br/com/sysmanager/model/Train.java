package br.com.sysmanager.model;

import java.util.ArrayList;
import java.util.List;

public class Train {

    public List<TrainCarriage> trainCarriages;

    public Train() {
        this.trainCarriages = new ArrayList<>();
    }

    public String toString(){
        String tremDetails = "";
        for(TrainCarriage trainCarriage : this.trainCarriages){
            tremDetails += String.format("Número do vagão: %d%nLado de inserção do vagão: %s%n", trainCarriage.getNumber(), trainCarriage.getInsertionSide());
        }
        return tremDetails;
    }
}
