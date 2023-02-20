package entity;

import java.util.Objects;

public class Delivery {
    private int delivery_id;
    private String delivery_status;
    private int users_user_id;

    public Delivery(int delivery_id, String delivery_status, int users_user_id) {
        this.delivery_id = delivery_id;
        this.delivery_status = delivery_status;
        this.users_user_id = users_user_id;
    }

    public Delivery(){}

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public int getUsers_user_id() {
        return users_user_id;
    }

    public void setUsers_user_id(int users_user_id) {
        this.users_user_id = users_user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return delivery_id == delivery.delivery_id && users_user_id == delivery.users_user_id && Objects.equals(delivery_status, delivery.delivery_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delivery_id, delivery_status, users_user_id);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "delivery_id=" + delivery_id +
                ", delivery_status='" + delivery_status + '\'' +
                ", users_user_id=" + users_user_id +
                '}';
    }
}
