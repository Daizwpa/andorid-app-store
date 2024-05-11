package Model;

import androidx.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDateTime;
import java.util.Date;

@DatabaseTable(tableName = "Order")
public class Order {
    @DatabaseField(generatedId = true)
    private int ID;
    @DatabaseField(foreign = true, canBeNull = false)
    private Customer customer;

    @DatabaseField(canBeNull = false )
    private java.util.Date date;

    @DatabaseField(canBeNull = false)
    private String Location;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }


    @NonNull
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(ID);
        sb.append(", ").append("customer").append(customer.toString());
        sb.append(", ").append("date").append(date);
        sb.append(", ").append("location").append(Location);
        return sb.toString();
    }
}
