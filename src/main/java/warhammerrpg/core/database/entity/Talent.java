package warhammerrpg.core.database.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * zdolności
 */
@DatabaseTable()
public class Talent {

    public Talent() {
    }

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField()
    private String name;

    @DatabaseField(dataType= DataType.LONG_STRING)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
