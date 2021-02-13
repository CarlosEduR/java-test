package br.com.sysmanager;

import br.com.sysmanager.composition.CounterComposition;
import br.com.sysmanager.composition.TrainComposition;
import br.com.sysmanager.model.TrainCarriage;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        TrainComposition trainComposition = new TrainComposition();
        CounterComposition counterComposition = new CounterComposition();

        int[] array = { 2, 4, 1, 9, 8 }; // Array referente ao Desafio 2
        int lessThan = 3; // Parâmetro referente ao Desafio 2

        while(choice != 7){
            System.out.println("\n---------- MENU ----------" +
                    "\nDigite o número correspondente à funcionalidade:\n" +
                    "\n1. Adicionar vagão ao trem" +
                    "\n2. Listar vagões do trem" +
                    "\n3. Listar possibilidades ordenadas para remoção dos vagões" +
                    "\n4. Remover todos vagões do trem" +
                    "\n5. Atracar 5 vagões pré-definidos ao trem" +
                    "\n6. Rodar funcão countNumbers" +
                    "\n7. Sair\n");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Digite o número do vagão: ");
                    int number = scanner.nextInt();
                    System.out.print("Escolha um lado para inserção do vagão (esquerdo ou direito): ");
                    String side = scanner.next();
                    trainComposition.addTrainCarriage(number, side.toLowerCase(Locale.ROOT));
                    break;
                case 2:
                    List<TrainCarriage> allTrainCarriages = trainComposition.listAllTrainCarriages();
                    if(allTrainCarriages.size() > 0){
                        for(TrainCarriage trainCarriage : allTrainCarriages){
                            System.out.println(String.format("\nNúmero do vagão: %d",trainCarriage.number));
                            System.out.println(String.format("Lado de inserção: %s",trainCarriage.insertionSide));
                        }
                    }else{
                        System.out.println("Por enquanto o trem está sem vagões.");
                    }
                    break;
                case 3:
                    RemovalPossibilities removalPossibilities = trainComposition.listAllPossibilities();
                    System.out.println("Possibilidade ordenada de remoção de vagões pela direita:");
                    for (Integer trainCarriageNumber : removalPossibilities.getRightPossibility()){
                        System.out.println(trainCarriageNumber);
                    }
                    System.out.println("Possibilidade ordenada de remoção de vagões pela esquerda:");
                    for (Integer trainCarriageNumber : removalPossibilities.getLeftPossibility()){
                        System.out.println(trainCarriageNumber);
                    }
                    break;
                case 4:
                    if(trainComposition.train.trainCarriages.size() > 0){
                        trainComposition.removeAllTrainCarriages();
                    }else{
                        System.out.println("Sem vagões a serem desatracados.");
                    }
                    break;
                case 5:
                    trainComposition.initializeFiveRandomTrainCarriage();
                    System.out.println("5 vagões foram atracados.");
                    break;
                case 6:
                    int quantity = counterComposition.countNumbers(array, lessThan);
                    System.out.println(String.format("Array informado: %s. ", Arrays.toString(array)));
                    if(quantity > 0) {
                        System.out.println(String.format("%d elemento(s) menor(es) que o parâmetro informado [%d].", quantity, lessThan));
                    }
                    break;
                case 7:
                    System.out.println("Finalizando aplicação.");
                    break;
            }
        }
    }
}
