package entity;

import java.util.Objects;

public class ShoppingCart {
    private int user_id;
    private int product_id;
    private int orders_order_id;

    public ShoppingCart(int user_id, int product_id, int orders_order_id) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.orders_order_id = orders_order_id;
    }

    public ShoppingCart(){}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrders_order_id() {
        return orders_order_id;
    }

    public void setOrders_order_id(int orders_order_id) {
        this.orders_order_id = orders_order_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return user_id == that.user_id && product_id == that.product_id && orders_order_id == that.orders_order_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, product_id, orders_order_id);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "user_id=" + user_id +
                ", product_id=" + product_id +
                ", orders_order_id=" + orders_order_id +
                '}';
    }
}
