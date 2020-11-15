package com.russu.lab1.store;

import com.russu.lab1.employee.DeputyDirector;
import com.russu.lab1.employee.Director;
import com.russu.lab1.employee.Seller;
import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.product.Product;
import com.russu.lab1.provider.Provider;

import java.util.ArrayList;

public class Store {

    private long storeId;
    private ArrayList<AssortmentProduct> assortmentProducts;
    private Director director;
    private DeputyDirector deputyDirector;
    private ArrayList<Seller> sellers;
    private ArrayList<Provider> providers;

    public Store(){
        assortmentProducts = new ArrayList<>();
        sellers = new ArrayList<>();
        providers = new ArrayList<>();
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

    public ArrayList<Provider> getProviders() {
        return providers;
    }
    public void getAllProviders(){
        System.out.println("Поставщики магазина:");
        for(int i=0; i < providers.size(); i++){
            System.out.println(providers.get(i).getName());
        }
        System.out.println();
    }

    //добавление поставщика в список
    public void setProviders(ArrayList<Provider> providers) {
        this.providers = providers;
    }
    public void setProviders(Provider... provider){
        if(providers.size() == 0){
            providers.add(provider[0]);
        }
        for(int i = 0; i < provider.length; i++){
            for (int j = 0; j < providers.size(); j++){
                if(providers.get(j).getName() == provider[i].getName()){
                    break;
                }
                if(j+1 == providers.size()){
                    providers.add(provider[i]);
                }
            }
        }
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
                    assortmentProducts.get(i).getProduct().getValue())
            );
        }
        System.out.println();
    }
    public ArrayList<AssortmentProduct> getAssortmentProducts() {
        return assortmentProducts;
    }

    //Добавить новый продукт в список или изменить количество продукта
    public void setProduct(Product product, int count){

        Product local = new Product(product.getName(), product.getValue()*1.2f);
        AssortmentProduct assortmentProduct = new AssortmentProduct(local, count);
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

    //Закупка продуктов у поставщика
    public void storeShopping(AssortmentProduct... assortmentProducts){

        int count = 0;

        for (int provider = 0; provider < providers.size(); provider++){
            for (int storePosition = 0; storePosition < assortmentProducts.length; storePosition++){
                for (int providerPosition = 0;
                     providerPosition < providers.get(provider).getAssortment().size();
                     providerPosition++)
                {
                    if( providers.get(provider).getAssortment().get(providerPosition).getProduct().getName() ==
                            assortmentProducts[storePosition].getProduct().getName())
                    {
                        this.setProduct(assortmentProducts[storePosition].getProduct(),
                                assortmentProducts[storePosition].getCount()
                        );

                        count = count + 1;
                        break;
                    }
                }

            }
            if(count == assortmentProducts.length){
                break;
            }
        }
    }

}
