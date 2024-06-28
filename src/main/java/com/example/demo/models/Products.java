package com.example.demo.models;

public class Products {
    private double unitPrice;
    private int inven;

    public Products(double up, int inv) {
        this.unitPrice = up;
        this.inven = inv;
    }

    
    public int getInven() {
        return inven;
    }


    public void buyProduct(int num) {
        // transaction
        // o = new Order => Order.add(o)
        if (num < 0) {
            throw new IllegalArgumentException("negative value");
        } else if (this.inven-num < 0) {
            throw new IllegalStateException("negative inven");
        }
        this.inven -= num;
    }
}
