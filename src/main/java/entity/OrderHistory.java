package entity;

import java.sql.Timestamp;
import java.util.Objects;

public class OrderHistory {
    private int order_id;
    private Timestamp history_time;
    private String history_status;
    private int orders_order_id;

    public OrderHistory(int order_id, Timestamp history_time, String history_status, int orders_order_id) {
        this.order_id = order_id;
        this.history_time = history_time;
        this.history_status = history_status;
        this.orders_order_id = orders_order_id;
    }

    public OrderHistory(){}

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Timestamp getHistory_time() {
        return history_time;
    }

    public void setHistory_time(Timestamp history_time) {
        this.history_time = history_time;
    }

    public String getHistory_status() {
        return history_status;
    }

    public void setHistory_status(String history_status) {
        this.history_status = history_status;
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
        OrderHistory that = (OrderHistory) o;
        return order_id == that.order_id && orders_order_id == that.orders_order_id && Objects.equals(history_time, that.history_time) && Objects.equals(history_status, that.history_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, history_time, history_status, orders_order_id);
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "order_id=" + order_id +
                ", history_time=" + history_time +
                ", history_status='" + history_status + '\'' +
                ", orders_order_id=" + orders_order_id +
                '}';
    }
}
