package warhammerrpg.core.database.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class CareerToTalent {
    public CareerToTalent() {
    }

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(foreign = true)
    Career career;

    @DatabaseField(foreign = true)
    Talent talent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }
}
