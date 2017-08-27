package warhammerrpg.core.person;

public class Ability {
    public Ability(String ability, String abilityDescription) {
        this.ability = ability;
        this.abilityDescription = abilityDescription;
    }

    private String ability;
    private String abilityDescription;
    
    public Ability(String ability) {
        this.ability = ability;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getabilityDescription() {
        return abilityDescription;
    }

    public void setabilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
    }



}
