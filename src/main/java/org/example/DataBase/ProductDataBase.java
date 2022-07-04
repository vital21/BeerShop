package org.example.DataBase;

import org.example.service.Beer;
import org.example.service.ProductBuy;

import java.util.ArrayList;

public interface ProductDataBase {
    ArrayList<Beer> select() throws ClassNotFoundException;

    Beer selectById(int id);

    int insert(String nameBeer, String containerType, double volumeContainerBeer, String typeBeer, double percentageOfAlcoholBeer, int bitternessOfBeer, int quantityOfBeer);

    void editQuantityBuy(ArrayList<ProductBuy> productBuy);

    void deleteById();

    int edit(int id, double volumeContainerBeer, int quantityOfBeer);
}
