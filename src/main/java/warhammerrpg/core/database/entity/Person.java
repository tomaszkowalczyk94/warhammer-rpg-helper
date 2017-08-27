package warhammerrpg.core.database.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable()
public class Person {


    @DatabaseField(generatedId = true)
    protected int id;

    @ForeignCollectionField(eager = false)
    ForeignCollection<PersonToSkill> personsToSkills;

    @ForeignCollectionField(eager = false)
    ForeignCollection<PersonToWeapon> weaponToSkills;

    /**
     * wyposażenie
     */
    @ForeignCollectionField(eager = false)
    ForeignCollection<Equipment> trappings;




    //bohater
    @DatabaseField()
    private String name;
    @DatabaseField()
    private String breed;
    @DatabaseField()
    private String curProffesion;
    @DatabaseField()
    private String prevProffesion;

    //opis bohatera
    @DatabaseField()
    private String age;
    @DatabaseField()
    private String eyesColour;
    @DatabaseField()
    private String hairColour;
    @DatabaseField()
    private String starSign;
    @DatabaseField()
    private String sex;
    @DatabaseField()
    private String weight;
    @DatabaseField()
    private String height;
    @DatabaseField()
    private String siblings;
    @DatabaseField()
    private String birthPlace;
    @DatabaseField()
    private String specialSigns;

    /**
     * Walka wręcz (WS)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature weaponSkill;

    /**
     * Umiejętności strzeleckie (US)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature ballisticSkill;

    /**
     * Krzepa (K)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature strength;

    /**
     * Odporność (Odp)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature toughness;

    /**
     * Zręczność (Zr)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature agility;

    /**
     * Siła woli (SW)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature willPower;

    /**
     * Ogłada (Ogd)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature fellowship;

    /**
     * Ataki (a)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature attack;

    /**
     * Żywotność (Żyw)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature wounds;

    /**
     * Siła (S)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature strengthBonus;

    /**
     * Wytrzymałość (Wt)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature toughnessBonus;

    /**
     * Szybkość (Sz)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature movement;

    /**
     * Magia (Mag)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature magic;

    /**
     * Punkty obłędu (PO)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature insanityPoints;

    /**
     * Punkty przeznaczenia (PP)
     */
    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Feature fatePoints;

    ///Gracz
    @DatabaseField()
    private String gamerName;
    @DatabaseField()
    private String gameNaster;
    @DatabaseField()
    private String campaign;
    @DatabaseField()
    private Integer campaignYear;

    ///Punkty Doswiadczenia
    @DatabaseField()
    private String curExp;
    @DatabaseField()
    private String allExp;

    ///Ruch w walce
    @DatabaseField()
    private Integer move;
    @DatabaseField()
    private Integer attackRun; ///Szarża
    @DatabaseField()
    private Integer run;

    ///Obrazek - Punkty Zbroi
    @DatabaseField()
    private Integer head;
    @DatabaseField()
    private Integer body;
    @DatabaseField()
    private Integer rightHand;
    @DatabaseField()
    private Integer leftHand;
    @DatabaseField()
    private Integer rightLeg;
    @DatabaseField()
    private Integer leftLeg;

    ///pieniądze
    @DatabaseField()
    private String gold;
    @DatabaseField()
    private String silver;
    @DatabaseField()
    private String brass;  ///mosiądź

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ForeignCollection<PersonToSkill> getPersonsToSkills() {
        return personsToSkills;
    }

    public void setPersonsToSkills(ForeignCollection<PersonToSkill> personsToSkills) {
        this.personsToSkills = personsToSkills;
    }

    public ForeignCollection<PersonToWeapon> getWeaponToSkills() {
        return weaponToSkills;
    }

    public void setWeaponToSkills(ForeignCollection<PersonToWeapon> weaponToSkills) {
        this.weaponToSkills = weaponToSkills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCurProffesion() {
        return curProffesion;
    }

    public void setCurProffesion(String curProffesion) {
        this.curProffesion = curProffesion;
    }

    public String getPrevProffesion() {
        return prevProffesion;
    }

    public void setPrevProffesion(String prevProffesion) {
        this.prevProffesion = prevProffesion;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEyesColour() {
        return eyesColour;
    }

    public void setEyesColour(String eyesColour) {
        this.eyesColour = eyesColour;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public String getStarSign() {
        return starSign;
    }

    public void setStarSign(String starSign) {
        this.starSign = starSign;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSiblings() {
        return siblings;
    }

    public void setSiblings(String siblings) {
        this.siblings = siblings;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getSpecialSigns() {
        return specialSigns;
    }

    public void setSpecialSigns(String specialSigns) {
        this.specialSigns = specialSigns;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public String getGameNaster() {
        return gameNaster;
    }

    public void setGameNaster(String gameNaster) {
        this.gameNaster = gameNaster;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Integer getCampaignYear() {
        return campaignYear;
    }

    public void setCampaignYear(Integer campaignYear) {
        this.campaignYear = campaignYear;
    }

    public String getCurExp() {
        return curExp;
    }

    public void setCurExp(String curExp) {
        this.curExp = curExp;
    }

    public String getAllExp() {
        return allExp;
    }

    public void setAllExp(String allExp) {
        this.allExp = allExp;
    }

    public Integer getMove() {
        return move;
    }

    public void setMove(Integer move) {
        this.move = move;
    }

    public Integer getAttackRun() {
        return attackRun;
    }

    public void setAttackRun(Integer attackRun) {
        this.attackRun = attackRun;
    }

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getBody() {
        return body;
    }

    public void setBody(Integer body) {
        this.body = body;
    }

    public Integer getRightHand() {
        return rightHand;
    }

    public void setRightHand(Integer rightHand) {
        this.rightHand = rightHand;
    }

    public Integer getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Integer leftHand) {
        this.leftHand = leftHand;
    }

    public Integer getRightLeg() {
        return rightLeg;
    }

    public void setRightLeg(Integer rightLeg) {
        this.rightLeg = rightLeg;
    }

    public Integer getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(Integer leftLeg) {
        this.leftLeg = leftLeg;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getBrass() {
        return brass;
    }

    public void setBrass(String brass) {
        this.brass = brass;
    }

    public Feature getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(Feature weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public Feature getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(Feature ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public Feature getStrength() {
        return strength;
    }

    public void setStrength(Feature strength) {
        this.strength = strength;
    }

    public Feature getToughness() {
        return toughness;
    }

    public void setToughness(Feature toughness) {
        this.toughness = toughness;
    }

    public Feature getAgility() {
        return agility;
    }

    public void setAgility(Feature agility) {
        this.agility = agility;
    }

    public Feature getWillPower() {
        return willPower;
    }

    public void setWillPower(Feature willPower) {
        this.willPower = willPower;
    }

    public Feature getFellowship() {
        return fellowship;
    }

    public void setFellowship(Feature fellowship) {
        this.fellowship = fellowship;
    }

    public Feature getAttack() {
        return attack;
    }

    public void setAttack(Feature attack) {
        this.attack = attack;
    }

    public Feature getWounds() {
        return wounds;
    }

    public void setWounds(Feature wounds) {
        this.wounds = wounds;
    }

    public Feature getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(Feature strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public Feature getToughnessBonus() {
        return toughnessBonus;
    }

    public void setToughnessBonus(Feature toughnessBonus) {
        this.toughnessBonus = toughnessBonus;
    }

    public Feature getMovement() {
        return movement;
    }

    public void setMovement(Feature movement) {
        this.movement = movement;
    }

    public Feature getMagic() {
        return magic;
    }

    public void setMagic(Feature magic) {
        this.magic = magic;
    }

    public Feature getInsanityPoints() {
        return insanityPoints;
    }

    public void setInsanityPoints(Feature insanityPoints) {
        this.insanityPoints = insanityPoints;
    }

    public Feature getFatePoints() {
        return fatePoints;
    }

    public void setFatePoints(Feature fatePoints) {
        this.fatePoints = fatePoints;
    }

    public ForeignCollection<Equipment> getTrappings() {
        return trappings;
    }

    public void setTrappings(ForeignCollection<Equipment> trappings) {
        this.trappings = trappings;
    }

    public void printPerson()
    {
        System.out.println("imie: " + getName()+
                "\nRasa: " + getBreed()+
                "\nProfesja: " + getCurProffesion()+
                "\nWiek: "+ getAge()+
                "\nPłeć: " + getSex()+
                "\nMiejsce urodzenia: " +getBirthPlace()+
                "\nZłoto: " + getGold());
    }


/* test obiektu
    public static void main(String args[])
    {
        person obj = new person ("wojtek",Breed.Elf,"Mag",22,"M","Miejsce",BigDecimal.valueOf(200));
        System.out.println(obj.name);
        obj.setBody(32);
        System.out.println("Body="+obj.getBody());
        System.out.println("Exp="+obj.getExpPresent());
        System.out.println("Gold="+obj.getGold());
    }
*/
}
