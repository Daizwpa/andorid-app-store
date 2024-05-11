package Model;

import androidx.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="Product")
public class Product {
    @DatabaseField(generatedId = true)
    private  int ID;
    @DatabaseField(canBeNull = false, defaultValue = "product1")
    private String Name;
    @DatabaseField(canBeNull = false, defaultValue = "0")
    private int Quantity;

    @DatabaseField(canBeNull = false, defaultValue = "0.00")
    private double Price;

    public Product()
    {

    }

    public Product(int ID, String Name, int Quantity, double Price){
        this.ID = ID;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Price = Price;
    }
    @NonNull
    @Override
    public  String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID=").append(ID);
        return sb.toString();
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
