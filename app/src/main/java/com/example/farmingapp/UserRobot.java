package com.example.farmingapp;

public class UserRobot {

    private float temperature;
    private float humidity_soil;
    private float humidity_air;
    private float luminosity;


    public UserRobot(float temperature, float humidity_soil, float humidity_air, float luminosity) {
        this.temperature = temperature;
        this.humidity_soil = humidity_soil;
        this.humidity_air = humidity_air;
        this.luminosity = luminosity;
    }



    public float getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(float luminosity) {
        this.luminosity = luminosity;
    }

    public float getHumidity_air() {
        return humidity_air;
    }

    public void setHumidity_air(float humidity_air) {
        this.humidity_air = humidity_air;
    }


    public float getTemperature(){
        return temperature;
    }

    public void setTemperature (float t){
        temperature=t;
    }

    public float getHumidity_soil(){
        return humidity_soil;
    }

    public void setHumidity_soil (float humidity_soil) {
        this.humidity_soil = humidity_soil;
    }


    public UserRobot() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

}
