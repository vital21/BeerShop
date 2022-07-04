package org.example.service;

public class Beer {
    private int id;
    private String nameBeer;
    private String containerType;
    private double volumeContainerBeer;
    private String typeBeer;
    private double percentageOfAlcoholBeer;
    private int bitternessOfBeer;
    private int quantityOfBeer;


    Beer() {

    }

    ;

    public Beer(int id, String nameBeer, String containerType, double volumeContainerBeer, String typeBeer, double percentageOfAlcoholBeer, int bitternessOfBeer, int quantityOfBeer) {
        setId(id);
        setNameBeer(nameBeer);
        setContainerType(containerType);
        setVolumeContainerBeer(volumeContainerBeer);
        setTypeBeer(typeBeer);
        setPercentageOfAlcoholBeer(percentageOfAlcoholBeer);
        setBitternessOfBeer(bitternessOfBeer);
        setQuantityOfBeer(quantityOfBeer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public int getQuantityOfBeer() {
        return quantityOfBeer;
    }

    public void setQuantityOfBeer(int quantityOfBeer) {
        this.quantityOfBeer = quantityOfBeer;
    }

    public String getNameBeer() {
        return nameBeer;
    }

    public void setNameBeer(String nameBeer) {
        this.nameBeer = nameBeer;
    }

    public double getVolumeContainerBeer() {
        return volumeContainerBeer;
    }

    public void setVolumeContainerBeer(double volumeContainerBeer) {
        this.volumeContainerBeer = volumeContainerBeer;
    }

    public String getTypeBeer() {
        return typeBeer;
    }

    public void setTypeBeer(String typeBeer) {
        this.typeBeer = typeBeer;
    }

    public double getPercentageOfAlcoholBeer() {
        return percentageOfAlcoholBeer;
    }

    public void setPercentageOfAlcoholBeer(double percentageOfAlcoholBeer) {
        this.percentageOfAlcoholBeer = percentageOfAlcoholBeer;
    }

    public int getBitternessOfBeer() {
        return bitternessOfBeer;
    }

    public void setBitternessOfBeer(int bitternessOfBeer) {
        this.bitternessOfBeer = bitternessOfBeer;
    }

}
