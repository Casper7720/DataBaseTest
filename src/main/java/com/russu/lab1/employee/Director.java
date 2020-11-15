package com.russu.lab1.employee;

import com.russu.lab1.employee.Schedule.Schedule;
import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.store.Store;

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
                        store.setProduct(assortmentProducts[storePosition].getProduct(),
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
