package com.example.listsandadapters;

public class State {
    private String name; // название
    private String description;  // Описание
    private int CarResource; // ресурс изображения машин
    private int Kolvo;

    public State(String name, String description, int Car, int Kolvo) {

        this.name = name;
        this.description = description;
        this.CarResource = Car;
        this.Kolvo = Kolvo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCarResource() { return this.CarResource; }

    public void setCarResource(int CarResource) {
        this.CarResource = CarResource;
    }

    public int getKolvoCar() {
        return this.Kolvo;
    }

    public void setKolvoCar(int Kolvo) { this.Kolvo = Kolvo; }
}



