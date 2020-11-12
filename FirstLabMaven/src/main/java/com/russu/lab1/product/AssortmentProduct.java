package com.russu.lab1.product;



public class AssortmentProduct {

    private Product product;
    private int count;

    public AssortmentProduct(Product product, int count){
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void countSummer(int value){
        this.count += value;
    }
}
