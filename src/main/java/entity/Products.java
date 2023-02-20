package entity;

import java.util.Objects;

public class Products {
    private int product_id;
    private String product_name;
    private double product_price;
    private String product_description;
    private int supplier_id;
    private int categories_category_id;
    private int shopping_cart_user_id;
    private int shopping_cart_product_id;
    private int shopping_cart_orders_order_id;

    public Products(int product_id, String product_name, double product_price, String product_description, int supplier_id, int categories_category_id, int shopping_cart_user_id, int shopping_cart_product_id, int shopping_cart_orders_order_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.supplier_id = supplier_id;
        this.categories_category_id = categories_category_id;
        this.shopping_cart_user_id = shopping_cart_user_id;
        this.shopping_cart_product_id = shopping_cart_product_id;
        this.shopping_cart_orders_order_id = shopping_cart_orders_order_id;
    }

    public Products () {}

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getCategories_category_id() {
        return categories_category_id;
    }

    public void setCategories_category_id(int categories_category_id) {
        this.categories_category_id = categories_category_id;
    }

    public int getShopping_cart_user_id() {
        return shopping_cart_user_id;
    }

    public void setShopping_cart_user_id(int shopping_cart_user_id) {
        this.shopping_cart_user_id = shopping_cart_user_id;
    }

    public int getShopping_cart_product_id() {
        return shopping_cart_product_id;
    }

    public void setShopping_cart_product_id(int shopping_cart_product_id) {
        this.shopping_cart_product_id = shopping_cart_product_id;
    }

    public int getShopping_cart_orders_order_id() {
        return shopping_cart_orders_order_id;
    }

    public void setShopping_cart_orders_order_id(int shopping_cart_orders_order_id) {
        this.shopping_cart_orders_order_id = shopping_cart_orders_order_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return product_id == products.product_id && Double.compare(products.product_price, product_price) == 0 && supplier_id == products.supplier_id && categories_category_id == products.categories_category_id && shopping_cart_user_id == products.shopping_cart_user_id && shopping_cart_product_id == products.shopping_cart_product_id && shopping_cart_orders_order_id == products.shopping_cart_orders_order_id && Objects.equals(product_name, products.product_name) && Objects.equals(product_description, products.product_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, product_name, product_price, product_description, supplier_id, categories_category_id, shopping_cart_user_id, shopping_cart_product_id, shopping_cart_orders_order_id);
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_description='" + product_description + '\'' +
                ", supplier_id=" + supplier_id +
                ", categories_category_id=" + categories_category_id +
                ", shopping_cart_user_id=" + shopping_cart_user_id +
                ", shopping_cart_product_id=" + shopping_cart_product_id +
                ", shopping_cart_orders_order_id=" + shopping_cart_orders_order_id +
                '}';
    }
}
