package br.com.sysmanager.composition;

import br.com.sysmanager.RemovalPossibilities;
import br.com.sysmanager.model.Train;
import br.com.sysmanager.model.TrainCarriage;
import java.util.ArrayList;
import java.util.List;

public class TrainComposition {

    public Train train;
    public static String LEFT_SIDE = "esquerdo";
    public static String RIGHT_SIDE = "direito";

    public TrainComposition() {
        this.train = new Train();
    }

    public void initializeFiveRandomTrainCarriage() {
        List<TrainCarriage> trainCarriages = new ArrayList<>();
        trainCarriages.add(new TrainCarriage(7, RIGHT_SIDE));
        trainCarriages.add(new TrainCarriage(5, LEFT_SIDE));
        trainCarriages.add(new TrainCarriage(1, LEFT_SIDE));
        trainCarriages.add(new TrainCarriage(2, RIGHT_SIDE));
        trainCarriages.add(new TrainCarriage(9, RIGHT_SIDE));

        trainCarriages.forEach((trainCarriage) -> {
            addTrainCarriage(trainCarriage.getNumber(),  trainCarriage.getInsertionSide());
        });

        System.out.println(this.train.toString());
    }

    public void removeAllTrainCarriages(){
        this.train.trainCarriages = new ArrayList<>();
    }

    public List<TrainCarriage> addTrainCarriage(int number, String side){
//        System.out.println("Número do vagão a ser adicionado: " + number );
//        System.out.println("Lado: " + side );
        if(isSideValid(side) && !trainCarriageNumberAlreadyExists(number)){
            TrainCarriage trainCarriage = new TrainCarriage(number, side);
            if(trainCarriage.getInsertionSide().equals(RIGHT_SIDE)){
                this.train.trainCarriages.add(0, trainCarriage);
            }else{
                this.train.trainCarriages.add(trainCarriage);
            }
            System.out.println(String.format("Vagão [%d] atracado ao trem.", number));
        }

        return this.train.trainCarriages;
    }

    public RemovalPossibilities listAllPossibilities(){
        int quantity = this.train.trainCarriages.size();
        RemovalPossibilities removalPossibilities = new RemovalPossibilities();
        if(quantity > 0){
            for(int i = this.train.trainCarriages.size() - 1; i >= 0; i--){
                removalPossibilities.getLeftPossibility().add(this.train.trainCarriages.get(i).number);
            }

            for(int i = 0; i < this.train.trainCarriages.size(); i++){
                removalPossibilities.getRightPossibility().add(this.train.trainCarriages.get(i).number);
            }
        }else{
            System.out.println("Trem está sem vagões atracados.");
        }

        return removalPossibilities;
    }

    private boolean trainCarriageNumberAlreadyExists(int numeroVagao){
        Long quantity = this.train.trainCarriages.stream().filter(trainCarriage -> trainCarriage.getNumber() == numeroVagao).count();
        if(quantity > 0)
            System.out.println(String.format("Número de vagão informado [%s] já atracado ao trem.", numeroVagao));

        return quantity != 0 ? true : false;
    }

    private boolean isSideValid(String ladoInsercao){
        boolean valid = false;
        if(ladoInsercao.equals(RIGHT_SIDE) || ladoInsercao.equals(LEFT_SIDE)){
            valid = true;
        }else{
            System.out.println(String.format("Lado informado [%s] inválido. Valores possívieis: (%s, %s)", ladoInsercao, RIGHT_SIDE, LEFT_SIDE));
        }

        return valid;
    }

    public List<TrainCarriage> listAllTrainCarriages() {
        return this.train.trainCarriages;
    }
}
