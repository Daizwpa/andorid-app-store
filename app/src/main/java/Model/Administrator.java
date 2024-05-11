package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Administrator")
public class Administrator extends User {
    @DatabaseField(generatedId = true)
    private int ID;


    @DatabaseField(canBeNull = false)
    private String Name;

    public Administrator(){
        super();
    }
    public Administrator(int id, String name, String username, String password){
        this.ID = id;
        this.Name = name;
        this.Username = username;
        this.Password = password;
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
}
