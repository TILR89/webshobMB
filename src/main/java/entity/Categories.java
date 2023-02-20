package entity;

import java.util.Objects;

public class Categories {
    private int category_id;
    private String category_name;

    public Categories(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Categories(){}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return category_id == that.category_id && Objects.equals(category_name, that.category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, category_name);
    }

    @Override
    public String toString() {
        return "Categories{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
