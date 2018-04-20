package ru.ivmiit.projectFixCourse.fakeDataBase;

import ru.ivmiit.projectFixCourse.model.Product;

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
