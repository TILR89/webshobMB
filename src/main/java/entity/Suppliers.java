package entity;

import java.util.Objects;

public class Suppliers {
    private int supplier_id;
    private String supplier_name;

    public Suppliers(int supplier_id, String supplier_name) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
    }

    public Suppliers(){}

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suppliers suppliers = (Suppliers) o;
        return supplier_id == suppliers.supplier_id && Objects.equals(supplier_name, suppliers.supplier_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplier_id, supplier_name);
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "supplier_id=" + supplier_id +
                ", supplier_name='" + supplier_name + '\'' +
                '}';
    }
}
