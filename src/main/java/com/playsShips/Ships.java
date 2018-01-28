package com.playsShips;

import java.util.ArrayList;

public class Ships {
    private ArrayList<String> positionFields;
    private String name;

    public void setPositionFields(ArrayList<String> pFields){
        positionFields = pFields;
    }

    public void setName(String nameShip){
        name = nameShip;
    }
    public String checkMove(String move){
        String result = "Pudło";
        int index = positionFields.indexOf(move);
        if (index >= 0){
            positionFields.remove(index);
            if (positionFields.isEmpty()){
                result = "Zatopiony";
            }
            else {
                result = "Trafiony";
            }
        }
        return result;
    }
}
