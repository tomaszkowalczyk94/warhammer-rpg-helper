package warhammerrpg.database.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Weapon {
    public enum enumCategory { Jednoręczna, Dwuręczna, Strzelecka; }

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(uniqueIndex = true, canBeNull = false)
    private String name;

    /**
     * obciazenie
     */
    @DatabaseField()
    private Integer load;

    @DatabaseField()
    private enumCategory category;

    @DatabaseField()
    private Integer damage;

    @DatabaseField()
    private Integer range;

    @DatabaseField()
    private Integer reloadTime;

    @DatabaseField()
    private String weaponFeatures;

    public Weapon() {
    }

    public Weapon(String name, Integer load, enumCategory category, Integer damage, Integer range, Integer reloadTime, String weaponFeatures) {
        this.name = name;
        this.load = load;
        this.category = category;
        this.damage = damage;
        this.range = range;
        this.reloadTime = reloadTime;
        this.weaponFeatures = weaponFeatures;
    }

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

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public enumCategory getCategory() {
        return category;
    }

    public void setCategory(enumCategory category) {
        this.category = category;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(Integer reloadTime) {
        this.reloadTime = reloadTime;
    }

    public String getWeaponFeatures() {
        return weaponFeatures;
    }

    public void setWeaponFeatures(String weaponFeatures) {
        this.weaponFeatures = weaponFeatures;
    }


}
