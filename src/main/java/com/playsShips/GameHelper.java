package com.playsShips;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String ABC = "abcdefg";
    private int lengthOfBoard = 7;
    private int sizeOfBoard = 49;
    private int [] board = new int[sizeOfBoard];
    private int numberOfShips = 0;

    public String takeInputData(String statement) {
        String lineOfEntry = null;
        System.out.print(statement + " ");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            lineOfEntry = bufferedReader.readLine();
            if (lineOfEntry.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return lineOfEntry;
    }
    public ArrayList arrangeTheShips(int sizeOfShip){
        ArrayList<String> occupiedFields = new ArrayList<String>();
        String [] coordinatesLnc = new String[sizeOfShip];
        String help = null;
        int [] coordinates = new int[sizeOfShip];
        int attempt = 0;
        boolean success = false;
        int position = 0;

        numberOfShips++;
        int inkr = 1;
        if ((numberOfShips % 2) == 1){
            inkr = lengthOfBoard;
        }

        while (!success & attempt < 200){
            position = (int) (Math.random() * sizeOfBoard);
            int x = 0;
            success = true;
            while (success && x < sizeOfShip){
                if (board[position] == 0) {
                    coordinates[x++] = position;
                    position += inkr;
                    if (position >= sizeOfBoard){
                        success = false;
                    }
                    if (x > 0 & (position % lengthOfBoard == 0)){
                        success = false;
                    }
                }
                else {
                    success = false;
                }
            }
        }
        int x = 0;
        int line = 0;
        int column = 0;
        while (x < sizeOfShip){
            board[coordinates[x]] = 1;
            line = (int) (coordinates[x] / lengthOfBoard);
            column = coordinates[x] % lengthOfBoard;
            help = String.valueOf(ABC.charAt(column));
            occupiedFields.add(help.concat(Integer.toString(line)));
            x++;
        }
        return occupiedFields;
    }
}
