package warhammerrpg.core.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class Account {

    public void setName(String name) {
        this.name = name;
    }

    @DatabaseField(id = true)
    private String name;

    public String getName() {
        return name;
    }
}
