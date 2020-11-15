package com.russu.lab1.employee;

import com.russu.lab1.employee.Schedule.Schedule;
import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.store.Store;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Director extends Employee{

    private final String position = "Director";
    private int price = 55_000;
    private Schedule scheduleDirector;

    public Director(String name, Store store) {
        super(name, store);

        scheduleDirector = new Schedule(position);
    }

    public int getPrice() {
        return price;
    }

    public String getPosition() {
        return position;
    }

    public Schedule getScheduleDirector() {
        return scheduleDirector;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //Закупка продуктов у поставщика
    public void storeShopping(AssortmentProduct... assortmentProducts){

        int count = 0;

        for (int provider = 0; provider < store.getProviders().size(); provider++){
            for (int storePosition = 0; storePosition < assortmentProducts.length; storePosition++){
                for (int providerPosition = 0;
                     providerPosition < store.getProviders().get(provider).getAssortment().size();
                     providerPosition++)
                {
                    if( store.getProviders().get(provider).getAssortment().get(providerPosition).getProduct().getName() ==
                            assortmentProducts[storePosition].getProduct().getName())
                    {

                        //Количество продукта, которые магазин может приобрести
                        int counts = (int) (store.getActiveMoney()/
                                store.getProviders().
                                        get(provider).
                                        getAssortment().
                                        get(providerPosition).
                                        getProduct().
                                        getValue());

                        if (counts >= assortmentProducts[storePosition].getCount()){
                            store.setProduct(assortmentProducts[storePosition].getProduct(),counts);

                            store.setActiveMoney(store.getActiveMoney()-store.getProviders().
                                    get(provider).
                                    getAssortment().
                                    get(providerPosition).
                                    getProduct().
                                    getValue()*counts
                            );
                            assortmentProducts[storePosition].setCount(0);
                        }
                        else if (counts < assortmentProducts[storePosition].getCount()){
                            store.setProduct(assortmentProducts[storePosition].getProduct(), counts);

                            store.setActiveMoney(store.getActiveMoney() - store.getProviders().
                                    get(provider).
                                    getAssortment().
                                    get(providerPosition).
                                    getProduct().
                                    getValue() * counts
                            );
                            assortmentProducts[storePosition].setCount(
                                    assortmentProducts[storePosition].getCount()-counts
                            );
                        }

                        count = count + 1;
                        break;
                    }
                }

            }
            if(count == assortmentProducts.length){
                break;
            }

        }

        store.setNecessaryProducts(new ArrayList<AssortmentProduct>(Arrays.asList(assortmentProducts)));
    }

}
