package Model;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Customer")
public class Customer extends User {

    public Customer(){
        super();
    }

    public Customer(int ID, String Name, String Username, String Password){
        super();
        this.ID = ID;
        this.Name = Name;
        this.Password = Password;
        this.Username = Username;

    }

    @DatabaseField(generatedId = true)
    private int ID;
    @DatabaseField(canBeNull = false, defaultValue = "unKnown")
    private String Name;


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

    @NonNull
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID=").append(ID);
        sb.append(",Name=").append(Name);
        return sb.toString();
    }

    @Override
    public String getUsername() {
        return this.Username;
    }

    @Override
    public void setUsername(String username) {
        this.Username = username;
    }

    @Override
    public String getPassword() {
        return this.Password;
    }

    @Override
    public void setPassword(String password) {
        this.Password = password;
    }
}
