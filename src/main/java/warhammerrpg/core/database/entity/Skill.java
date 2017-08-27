package warhammerrpg.core.database.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Skill {

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(uniqueIndex = true, canBeNull = false)
    private String name;

    @DatabaseField()
    private String relatedSkills; ///skile pokrewne

    @ForeignCollectionField(eager = false)
    ForeignCollection<PersonToSkill> personsToSkills;

    public Skill(){};

    public Skill(String skillName) {
        this.name = skillName;
        this.relatedSkills = "";
    }

    ///drugi konstruktor dokladniejszy
    public Skill(String skillName, String relatedSkills) {
        this.name = skillName;
        this.relatedSkills = relatedSkills;
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

    public String getRelatedSkills() {
        return relatedSkills;
    }

    public void setRelatedSkills(String relatedSkills) {
        this.relatedSkills = relatedSkills;
    }

    public ForeignCollection<PersonToSkill> getPersonsToSkills() {
        return personsToSkills;
    }

    public void setPersonsToSkills(ForeignCollection<PersonToSkill> personsToSkills) {
        this.personsToSkills = personsToSkills;
    }



}
