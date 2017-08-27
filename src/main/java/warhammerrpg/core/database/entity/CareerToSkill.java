package warhammerrpg.core.database.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class CareerToSkill {

    public CareerToSkill() {
    }

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(foreign = true)
    Career career;

    @DatabaseField(foreign = true)
    Skill skill;

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
