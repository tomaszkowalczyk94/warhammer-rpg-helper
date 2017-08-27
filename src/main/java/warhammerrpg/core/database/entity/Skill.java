package warhammerrpg.core.database.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Skill {

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(uniqueIndex = true, canBeNull = false)
    private String name;

    @DatabaseField(dataType= DataType.LONG_STRING)
    private String description;

    @DatabaseField()
    private Boolean isAdvanced;

    @DatabaseField
    private String relatedTalentsString;

    @DatabaseField
    private String characteristic;

    @ForeignCollectionField(eager = false)
    ForeignCollection<PersonToSkill> personsToSkills;




    public Skill(){};

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

    public ForeignCollection<PersonToSkill> getPersonsToSkills() {
        return personsToSkills;
    }

    public void setPersonsToSkills(ForeignCollection<PersonToSkill> personsToSkills) {
        this.personsToSkills = personsToSkills;
    }



}
