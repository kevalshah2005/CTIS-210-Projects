/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfdrivingcar;


/**
 * Class that describes a Creature object to use in a moral machine scenario
 * @author keval
 */
public class Creature {
    private String description;
    private int value;
    private boolean crossingLegality;
    private int gender;
    private boolean fitness;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isCrossingLegality() {
        return crossingLegality;
    }

    public void setCrossingLegality(boolean crossingLegality) {
        this.crossingLegality = crossingLegality;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }   
}
