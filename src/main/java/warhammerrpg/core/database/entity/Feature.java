package warhammerrpg.core.database.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Feature {

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField()
    private Integer initialVal;

    @DatabaseField()
    private Integer devScheme;

    @DatabaseField()
    private Integer curVal;

    public Feature() {
    }

    public Feature(Integer initialVal, Integer devScheme, Integer curVal) {
        this.initialVal = initialVal;
        this.devScheme = devScheme;
        this.curVal = curVal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getInitialVal() {
        return initialVal;
    }

    public void setInitialVal(Integer initialVal) {
        this.initialVal = initialVal;
    }

    public Integer getDevScheme() {
        return devScheme;
    }

    public void setDevScheme(Integer devScheme) {
        this.devScheme = devScheme;
    }

    public Integer getCurVal() {
        return curVal;
    }

    public void setCurVal(Integer curVal) {
        this.curVal = curVal;
    }




}
