package entity;

import java.util.Objects;

public class Orders {
    private int order_id;
    private int user_id;
    private String user_name;
    private String user_email;

    public Orders(int order_id, int user_id, String user_name, String user_email) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
    }

    public Orders (){}

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return order_id == orders.order_id && user_id == orders.user_id && Objects.equals(user_name, orders.user_name) && Objects.equals(user_email, orders.user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, user_id, user_name, user_email);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
