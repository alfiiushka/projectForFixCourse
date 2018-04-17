package ru.ivmiit.projectFixCource.fakeDataBase;

import ru.ivmiit.projectFixCource.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
    private static volatile List<Product> instance;

    public ProductStorage() {
    }

    public static List<Product> getInstance() {
        if(instance==null)
            synchronized (ProductStorage.class){
            if(instance==null)
                instance=new ArrayList<Product>();
            }
        return instance;
    }
}
