package com.russu.lab1.provider;

import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.product.Product;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Provider {

    private String name;
    private ArrayList<AssortmentProduct> assortment;

    public Provider(String name, ArrayList<AssortmentProduct> assortmentProducts){
        this.name = name;
        this.assortment = assortmentProducts;
    }

    public Provider(String name){
        this.name = name;
        assortment = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Вывод ассортимента поставщика
    public ArrayList<AssortmentProduct> getAssortment() {
        return assortment;
    }
    public void getAllAssortment(){
        System.out.println(String.format("Продукты предосавленные поставщиком - %s", this.name));
        for (int i =0; i< assortment.size(); ++i){
            System.out.println(String.format(
                    "%s - закупочная цена %s",
                    assortment.get(i).getProduct().getName(),
                    assortment.get(i).getProduct().getValue())
            );
        }
        System.out.println();

    }

    //Добавления товара в ассортимент
    public void setAssortment(ArrayList<AssortmentProduct> assortment) {
        this.assortment = assortment;
    }
    public void setAssortment(Product product){
        AssortmentProduct assortmentProduct = new AssortmentProduct(product, Integer.MAX_VALUE);
        if(assortment.size() == 0){
            assortment.add(assortmentProduct);
        }
        else{
            for (int i = 0; i < assortment.size(); i++){
                if (assortment.get(i).getProduct().getName()==assortmentProduct.getProduct().getName()){
                    break;
                }
                else if(i+1==assortment.size()) {
                    assortment.add(assortmentProduct);
                    break;
                }

            }
        }
    }
}
