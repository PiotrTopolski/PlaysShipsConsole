package com.playsShips;

import java.util.ArrayList;

public class ShipsPlay {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ships> listOfShips = new ArrayList<Ships>();
    private int numberOfTurns = 0;

    public void prepareGame(){
        Ships firstShip = new Ships();
        firstShip.setName("Yamato");
        Ships secondShip = new Ships();
        secondShip.setName("Fuso");
        Ships thirdShip = new Ships();
        thirdShip.setName("Kongo");

        listOfShips.add(firstShip);
        listOfShips.add(secondShip);
        listOfShips.add(thirdShip);

        System.out.println("Your goal is to sing three ships.");
        System.out.println("Yamato, Fuso, Kongo");
        System.out.println("Try to make them drown in as few moves as possible.");

        for (Ships deployedShip : listOfShips){
            ArrayList<String> newLocation = helper.arrangeTheShips(3);
            deployedShip.setPositionFields(newLocation);
        }
    }
    public void startGame(){
        while (!listOfShips.isEmpty()){
            String playerMovement = helper.takeInputData("Enter the field: ");
            checkThePlayersMove(playerMovement);
        }
        endGame();
    }
    private void checkThePlayersMove(String move){
        numberOfTurns++;
        String result = "Mishit";
        for (Ships shipToCheck : listOfShips){
            result = shipToCheck.checkMove(move);
            if (result.equals("Trafiony")){
                break;
            }
            if (result.equals("Zatopiony")){
                listOfShips.remove(shipToCheck);
                break;
            }
        }
        System.out.println(result);
    }
    private void endGame(){
        System.out.println("All ships were sunk!");
        if (numberOfTurns <= 18){
            System.out.println("You only made " + numberOfTurns + " moves!");
        }
        else {
            System.out.println("You lost, you did it " + numberOfTurns + " moves!");
        }
    }
}
