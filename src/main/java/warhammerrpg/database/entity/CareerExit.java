package warhammerrpg.database.entity;

import com.j256.ormlite.field.DatabaseField;

public class CareerExit {

    public CareerExit() {
    }

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(foreign = true)
    protected Career career;

    @DatabaseField(foreign = true)
    protected Career careerExit;

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

    public Career getCareerExit() {
        return careerExit;
    }

    public void setCareerExit(Career careerExit) {
        this.careerExit = careerExit;
    }
}
