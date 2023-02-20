package entity;

import java.util.Objects;

public class ProductCategories {
    private int product_id;
    private int category_id;

    public ProductCategories(int product_id, int category_id) {
        this.product_id = product_id;
        this.category_id = category_id;
    }

    public ProductCategories(){}

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategories that = (ProductCategories) o;
        return product_id == that.product_id && category_id == that.category_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, category_id);
    }

    @Override
    public String toString() {
        return "ProductCategories{" +
                "product_id=" + product_id +
                ", category_id=" + category_id +
                '}';
    }
}
