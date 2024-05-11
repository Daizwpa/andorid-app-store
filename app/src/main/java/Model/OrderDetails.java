package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "OrderDetails")
public class OrderDetails {

    @DatabaseField(generatedId = true)
    private int ID;
    @DatabaseField(canBeNull = false, foreign = true)
    private Order order;

    @DatabaseField(canBeNull = false, foreign = true)
    private Product product;

    @DatabaseField(canBeNull = false, defaultValue = "0")
    private int Quantity;

    @DatabaseField(canBeNull = false, defaultValue = "0.00")
    private double Price_one_unite;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(ID);
        sb.append(", ").append("Order=").append(order.toString());
        sb.append(", ").append("product=").append(product.toString());
        sb.append(", ").append("Quantity=").append(Quantity);
        sb.append(", ").append("Price_one_unite=").append(Price_one_unite);
        return sb.toString();
    }
}
