package warhammerrpg.core.database.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class PersonToSkill {


    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(foreign = true)
    Person person;

    @DatabaseField(foreign = true)
    Skill skill;

    @DatabaseField()
    private Boolean plusTen; ///+10

    @DatabaseField()
    private Boolean plusTwenty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Boolean getPlusTen() {
        return plusTen;
    }

    public void setPlusTen(Boolean plusTen) {
        this.plusTen = plusTen;
    }

    public Boolean getPlusTwenty() {
        return plusTwenty;
    }

    public void setPlusTwenty(Boolean plusTwenty) {
        this.plusTwenty = plusTwenty;
    }

}
