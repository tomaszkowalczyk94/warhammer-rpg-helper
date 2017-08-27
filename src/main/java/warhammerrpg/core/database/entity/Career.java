package warhammerrpg.core.database.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Career {

    public Career() {
    }

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField()
    private String name;

    @DatabaseField()
    private String description;

    /**
     * Walka wręcz (WS)
     */
    @DatabaseField()
    private int weaponSkill;

    /**
     * Umiejętności strzeleckie (US)
     */
    @DatabaseField()
    private int ballisticSkill;

    /**
     * Krzepa (K)
     */
    @DatabaseField()
    private int strength;

    /**
     * Odporność (Odp)
     */
    @DatabaseField()
    private int toughness;

    /**
     * Zręczność (Zr)
     */
    @DatabaseField()
    private int agility;

    /**
     * Siła woli (SW)
     */
    @DatabaseField()
    private int willPower;

    /**
     * Ogłada (Ogd)
     */
    @DatabaseField()
    private int fellowship;

    /**
     * Ataki (a)
     */
    @DatabaseField()
    private int attack;

    /**
     * Żywotność (Żyw)
     */
    @DatabaseField()
    private int wounds;

    /**
     * Siła (S)
     */
    @DatabaseField()
    private int strengthBonus;

    /**
     * Wytrzymałość (Wt)
     */
    @DatabaseField()
    private int toughnessBonus;

    /**
     * Szybkość (Sz)
     */
    @DatabaseField()
    private int movement;

    /**
     * Magia (Mag)
     */
    @DatabaseField()
    private int magic;

    /**
     * Punkty obłędu (PO)
     */
    @DatabaseField()
    private int insanityPoints;

    /**
     * Punkty przeznaczenia (PP)
     */
    @DatabaseField()
    private int fatePoints;

    @ForeignCollectionField(eager = false)
    ForeignCollection<CareerToSkill> carrerToSkills;

    @ForeignCollectionField(eager = false)
    ForeignCollection<CareerToTalent> carrerToTalents;

    @DatabaseField()
    private String equipments;

    @ForeignCollectionField(eager = false, foreignFieldName="career")
    ForeignCollection<CareerExit> carrersExit;

    @DatabaseField()
    private Boolean isAdvanced;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(int weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public int getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(int ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getWillPower() {
        return willPower;
    }

    public void setWillPower(int willPower) {
        this.willPower = willPower;
    }

    public int getFellowship() {
        return fellowship;
    }

    public void setFellowship(int fellowship) {
        this.fellowship = fellowship;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getWounds() {
        return wounds;
    }

    public void setWounds(int wounds) {
        this.wounds = wounds;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public int getToughnessBonus() {
        return toughnessBonus;
    }

    public void setToughnessBonus(int toughnessBonus) {
        this.toughnessBonus = toughnessBonus;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getInsanityPoints() {
        return insanityPoints;
    }

    public void setInsanityPoints(int insanityPoints) {
        this.insanityPoints = insanityPoints;
    }

    public int getFatePoints() {
        return fatePoints;
    }

    public void setFatePoints(int fatePoints) {
        this.fatePoints = fatePoints;
    }

    public ForeignCollection<CareerToSkill> getCarrerToSkills() {
        return carrerToSkills;
    }

    public void setCarrerToSkills(ForeignCollection<CareerToSkill> carrerToSkills) {
        this.carrerToSkills = carrerToSkills;
    }

    public ForeignCollection<CareerToTalent> getCarrerToTalents() {
        return carrerToTalents;
    }

    public void setCarrerToTalents(ForeignCollection<CareerToTalent> carrerToTalents) {
        this.carrerToTalents = carrerToTalents;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

    public ForeignCollection<CareerExit> getCarrersExit() {
        return carrersExit;
    }

    public void setCarrersExit(ForeignCollection<CareerExit> carrersExit) {
        this.carrersExit = carrersExit;
    }

    public Boolean getAdvanced() {
        return isAdvanced;
    }

    public void setAdvanced(Boolean advanced) {
        isAdvanced = advanced;
    }
}
