package com.russu.lab1.store;

import com.russu.lab1.employee.DeputyDirector;
import com.russu.lab1.employee.Director;
import com.russu.lab1.employee.Seller;
import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.product.Product;

import java.util.ArrayList;

public class Store {

    private long storeId;
    private ArrayList<AssortmentProduct> assortmentProducts;
    private Director director;
    private DeputyDirector deputyDirector;
    private ArrayList<Seller> sellers;

    public Store(){
        assortmentProducts = new ArrayList<>();
        sellers = new ArrayList<>();
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public DeputyDirector getDeputyDirector() {
        return deputyDirector;
    }

    public void setDeputyDirector(DeputyDirector deputyDirector) {
        this.deputyDirector = deputyDirector;
    }

    public void setSellers(Seller seller) {
        this.sellers.add(seller);
    }

    // Вывод продавцов
    public void getAllSellers() {
        for (int i = 0; i < sellers.size(); i++){
            System.out.println(String.format("%s - %s", sellers.get(i).getPosition(),sellers.get(i).getName()));
        }
    }
    public ArrayList<Seller> getSellers() {
        return sellers;
    }


    // Вывод всех сотрудников
    public void getAllEmployees(){
        System.out.println(String.format("%s - %s", director.getPosition(), director.getName()));
        System.out.println(String.format("%s - %s ", deputyDirector.getPosition(), deputyDirector.getName()));
        getAllSellers();
        System.out.println();
    }


    public long getStoreId() {
        return storeId;
    }

    //Добавить продукты списком
    public void setAssortmentProducts(ArrayList<AssortmentProduct> assortmentProducts) {
        this.assortmentProducts = assortmentProducts;
    }

    //Вернуть список продуктов
    public void getAllAssortmentProducts() {
        System.out.println(String.format("Список продуктов в наличии магазина Шестерочка:"));
        for(int i=0; i < assortmentProducts.size();i++){
            System.out.println(String.format("%s - в количестве %s штук, цена за штуку : %s",
                    assortmentProducts.get(i).getProduct().getName(),
                    assortmentProducts.get(i).getCount(),
                    assortmentProducts.get(i).getProduct().getValue()*1.1)
            );
        }
        System.out.println();
    }
    public ArrayList<AssortmentProduct> getAssortmentProducts() {
        return assortmentProducts;
    }

    //Добавить новый продукт в список или изменить количество продукта
    public void setProduct(Product product, int count){
        AssortmentProduct assortmentProduct = new AssortmentProduct(product, count);
        if (assortmentProducts.size()==0){
            assortmentProducts.add(assortmentProduct);
        }
        else{
            for (int i = 0; i< assortmentProducts.size(); i++){
                if (assortmentProducts.get(i).getProduct().getName()==assortmentProduct.getProduct().getName()){
                    assortmentProducts.get(i).countSummer(assortmentProduct.getCount());
                    break;
                }
                else if(i+1==assortmentProducts.size()) {
                    assortmentProducts.add(assortmentProduct);
                    break;
                }

            }
        }

    }

}
