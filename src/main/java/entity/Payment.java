package entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Payment {
    private int payment_id;
    private Timestamp payment_date;
    private  int orders_order_id;

    public Payment(int payment_id, Timestamp payment_date, int orders_order_id) {
        this.payment_id = payment_id;
        this.payment_date = payment_date;
        this.orders_order_id = orders_order_id;
    }

    public Payment() {}

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public Timestamp getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Timestamp payment_date) {
        this.payment_date = payment_date;
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
        Payment payment = (Payment) o;
        return payment_id == payment.payment_id && orders_order_id == payment.orders_order_id && Objects.equals(payment_date, payment.payment_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment_id, payment_date, orders_order_id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", payment_date=" + payment_date +
                ", orders_order_id=" + orders_order_id +
                '}';
    }
}
