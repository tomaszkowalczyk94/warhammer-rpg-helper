package warhammerrpg.core.database.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Equipment {

    public Equipment() {
    }

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField()
    private String item;

    @DatabaseField()
    private String equipLoad;

    @DatabaseField()
    private String equipDescription;

    @DatabaseField(foreign = true)
    Person person;

    public Equipment(String item, String equipLoad, String equipDescription) {
        this.item = item;
        this.equipLoad = equipLoad;
        this.equipDescription = equipDescription;
    }

    public Equipment(String item, String equipLoad) {
        this.item = item;
        this.equipLoad = equipLoad;
        equipDescription = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getEquipLoad() {
        return equipLoad;
    }

    public void setEquipLoad(String equipLoad) {
        this.equipLoad = equipLoad;
    }

    public String getEquipDescription() {
        return equipDescription;
    }

    public void setEquipDescription(String equipDescription) {
        this.equipDescription = equipDescription;
    }
}
