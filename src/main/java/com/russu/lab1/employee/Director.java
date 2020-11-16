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
    public void storeShopping(){

        int count = 0;

        for (int provider = 0; provider < store.getProviders().size(); provider++){
            for (int storePosition = 0; storePosition < store.getNecessaryProducts().size(); storePosition++){
                for (int providerPosition = 0;
                     providerPosition < store.getProviders().get(provider).getAssortment().size();
                     providerPosition++)
                {
                    if( store.getProviders().
                            get(provider).
                            getAssortment().
                            get(providerPosition).
                            getProduct().
                            getName() == store.getNecessaryProducts().get(storePosition).getProduct().getName())
                    {

                        //Количество продукта, которые магазин может приобрести
                        int counts = (int) (store.getActiveMoney()/
                                store.getProviders().
                                        get(provider).
                                        getAssortment().
                                        get(providerPosition).
                                        getProduct().
                                        getValue()
                        );

                        if (counts >= store.getNecessaryProducts().get(storePosition).getCount()){

                            //Добавление продуктов в магазин
                            store.setProduct(store.getNecessaryProducts().get(storePosition).getProduct(),
                                    store.getNecessaryProducts().get(storePosition).getCount()
                            );
                            //Списание денег из актива магазина
                            store.setActiveMoney(store.getActiveMoney()-store.getProviders().
                                    get(provider).
                                    getAssortment().
                                    get(providerPosition).
                                    getProduct().
                                    getValue()* store.getNecessaryProducts().get(storePosition).getCount()
                            );
                            //Удаление продукта из списка необходимых
                            store.getNecessaryProducts().remove(storePosition);
                            storePosition--;
                        }
                        else if (counts < store.getNecessaryProducts().get(storePosition).getCount()){
                            //Добавление продуктов в магазин
                            store.setProduct(store.getNecessaryProducts().get(storePosition).getProduct(), counts);

                            //Списание денег из активов магазина
                            store.setActiveMoney(store.getActiveMoney() - store.getProviders().
                                    get(provider).
                                    getAssortment().
                                    get(providerPosition).
                                    getProduct().
                                    getValue() * counts
                            );

                            //Изменение количества необходимого к покупке
                            store.getNecessaryProducts().get(storePosition).setCount(
                                    store.getNecessaryProducts().get(storePosition).getCount()-counts
                            );
                        }
                        break;
                    }
                }

            }
            if(store.getNecessaryProducts().size() == 0){
                break;
            }
        }

    }

}
