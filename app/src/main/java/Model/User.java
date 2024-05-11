package Model;

import com.j256.ormlite.field.DatabaseField;

public abstract class User {
    @DatabaseField(canBeNull = false, index = true)
    public String Username = "";
    @DatabaseField(canBeNull = false, index = true)
    public String Password = "";

    public abstract String getUsername();

    public abstract void setUsername(String username);

    public abstract String getPassword();

    public abstract void setPassword(String password);

}
