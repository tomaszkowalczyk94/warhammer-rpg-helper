package warhammerrpg.database.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import warhammerrpg.database.manager.dao.PersonDao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static warhammerrpg.database.entity.PersonMethod.Type.GETTER;
import static warhammerrpg.database.entity.PersonMethod.Type.SETTER;

@DatabaseTable(daoClass = PersonDao.class)
public class Person {

    public enum Field {
        ID, NAME, BREED, CUR_CAREER, PREV_CAREER,
        AGE, EYES_COLOUR, HAIR_COLOUR, STAR_SIGN, SEX, WEIGHT, HEIGHT, SIBLINGS, BIRTH_PLACE, SPECIAL_SIGNS,

    }

    @DatabaseField(generatedId = true)
    protected int id;

    //bohater
    @PersonField(field=Field.NAME, name="imię")
    @DatabaseField()
    private String name;

    @PersonField(field=Field.BREED, name="rasa")
    @DatabaseField()
    private String breed;

    @PersonField(field=Field.CUR_CAREER, name="obecna profesja")
    @DatabaseField(foreign = true, foreignAutoRefresh=true)
    private Career curCareer;

    @PersonField(field=Field.PREV_CAREER, name="poprzednia profesja")
    @DatabaseField(foreign = true, foreignAutoRefresh=true)
    private Career prevCareer;


    @ForeignCollectionField(eager = false)
    ForeignCollection<PersonToSkill> personsToSkills;

    @ForeignCollectionField(eager = false)
    ForeignCollection<PersonToWeapon> weaponToSkills;

    /**
     * wyposażenie
     */
    @ForeignCollectionField(eager = false)
    ForeignCollection<Equipment> trappings;

    //opis bohatera
    @PersonField(field = Field.AGE, name="wiek")
    @DatabaseField()
    private String age;

    @PersonField(field = Field.EYES_COLOUR, name="kolor oczu")
    @DatabaseField()
    private String eyesColour;

    @PersonField(field = Field.HAIR_COLOUR, name="kolor włosów")
    @DatabaseField()
    private String hairColour;

    @PersonField(field = Field.STAR_SIGN, name="znak gwiezdny")
    @DatabaseField()
    private String starSign;

    @PersonField(field = Field.SEX, name="płeć")
    @DatabaseField()
    private String sex;

    @PersonField(field = Field.WEIGHT, name="waga")
    @DatabaseField()
    private String weight;

    @PersonField(field = Field.HEIGHT, name="wzrost")
    @DatabaseField()
    private String height;

    @PersonField(field = Field.SIBLINGS, name="rodzeństwo")
    @DatabaseField()
    private String siblings;

    @PersonField(field = Field.BIRTH_PLACE, name="miejsce urodzenia")
    @DatabaseField()
    private String birthPlace;

    @PersonField(field = Field.SPECIAL_SIGNS, name="znaki szczególne")
    @DatabaseField()
    private String specialSigns;

    /**
     * Walka wręcz (WW)
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
     * Inteligencja (Int)
     */
    @DatabaseField()
    private int intelligence;

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

    @PersonMethod(forField=Field.NAME, type=GETTER)
    public String getName() {
        return name;
    }

    @PersonMethod(forField=Field.NAME, type=SETTER)
    public void setName(String name) {
        this.name = name;
    }

    @PersonMethod(forField=Field.BREED, type=GETTER)
    public String getBreed() {
        return breed;
    }

    @PersonMethod(forField=Field.BREED, type=SETTER)
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @PersonMethod(forField=Field.CUR_CAREER, type=GETTER)
    public Career getCurCareer() {
        return curCareer;
    }

    @PersonMethod(forField=Field.CUR_CAREER, type=SETTER)
    public void setCurCareer(Career curCareer) {
        this.curCareer = curCareer;
    }

    @PersonMethod(forField=Field.PREV_CAREER, type=GETTER)
    public Career getPrevCareer() {
        return prevCareer;
    }

    @PersonMethod(forField=Field.PREV_CAREER, type=SETTER)
    public void setPrevCareer(Career prevCareer) {
        this.prevCareer = prevCareer;
    }

    @PersonMethod(forField=Field.AGE, type=GETTER)
    public String getAge() {
        return age;
    }

    @PersonMethod(forField=Field.AGE, type=SETTER)
    public void setAge(String age) {
        this.age = age;
    }

    @PersonMethod(forField=Field.EYES_COLOUR, type=GETTER)
    public String getEyesColour() {
        return eyesColour;
    }

    @PersonMethod(forField=Field.EYES_COLOUR, type=SETTER)
    public void setEyesColour(String eyesColour) {
        this.eyesColour = eyesColour;
    }

    @PersonMethod(forField=Field.HAIR_COLOUR, type=GETTER)
    public String getHairColour() {
        return hairColour;
    }

    @PersonMethod(forField=Field.HAIR_COLOUR, type=SETTER)
    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    @PersonMethod(forField=Field.STAR_SIGN, type=GETTER)
    public String getStarSign() {
        return starSign;
    }

    @PersonMethod(forField=Field.STAR_SIGN, type=SETTER)
    public void setStarSign(String starSign) {
        this.starSign = starSign;
    }

    @PersonMethod(forField=Field.SEX, type=GETTER)
    public String getSex() {
        return sex;
    }

    @PersonMethod(forField=Field.SEX, type=SETTER)
    public void setSex(String sex) {
        this.sex = sex;
    }

    @PersonMethod(forField=Field.WEIGHT, type=GETTER)
    public String getWeight() {
        return weight;
    }

    @PersonMethod(forField=Field.WEIGHT, type=SETTER)
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @PersonMethod(forField=Field.HEIGHT, type=GETTER)
    public String getHeight() {
        return height;
    }

    @PersonMethod(forField=Field.HEIGHT, type=SETTER)
    public void setHeight(String height) {
        this.height = height;
    }

    @PersonMethod(forField=Field.SIBLINGS, type=GETTER)
    public String getSiblings() {
        return siblings;
    }

    @PersonMethod(forField=Field.SIBLINGS, type=SETTER)
    public void setSiblings(String siblings) {
        this.siblings = siblings;
    }

    @PersonMethod(forField=Field.BIRTH_PLACE, type=GETTER)
    public String getBirthPlace() {
        return birthPlace;
    }

    @PersonMethod(forField=Field.BIRTH_PLACE, type=SETTER)
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @PersonMethod(forField=Field.SPECIAL_SIGNS, type=GETTER)
    public String getSpecialSigns() {
        return specialSigns;
    }

    @PersonMethod(forField=Field.SPECIAL_SIGNS, type=SETTER)
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

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    public Object getField(Field field) {
        Stream<Method> methodStream = Arrays.stream(this.getClass().getDeclaredMethods());

        Optional<Method> optionaMethod = methodStream
                .filter(method -> method.isAnnotationPresent(PersonMethod.class))
                .filter(method -> method.getAnnotation(PersonMethod.class).forField() == field)
                .filter(method -> method.getAnnotation(PersonMethod.class).type() == GETTER)
                .findFirst();

        try {
            return optionaMethod.get().invoke(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace(); //@todo
        } catch (InvocationTargetException e) {
            e.printStackTrace(); //@todo
        }
        return null;
    }

    public void setField(Field field, Object value) {
        final Stream<Method> methodStream = Arrays.stream(this.getClass().getDeclaredMethods());
        final Optional<Method> optionalMethod = methodStream
                .filter(method -> method.isAnnotationPresent(PersonMethod.class))
                .filter(method -> method.getAnnotation(PersonMethod.class).forField() == field)
                .filter(method -> method.getAnnotation(PersonMethod.class).type() == SETTER)
                .findFirst();

        try {
            optionalMethod.get().invoke(this, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace(); //@todo
        } catch (InvocationTargetException e) {
            e.printStackTrace(); //@todo
        }
    }

    public String getNameField(Field field) {

        Stream<java.lang.reflect.Field> fieldsStream = Arrays.stream(this.getClass().getDeclaredFields());

        final Optional<String> optionalName = fieldsStream.filter(f -> f.isAnnotationPresent(PersonField.class))
                .map(f -> f.getAnnotation(PersonField.class))
                .filter(annotation -> annotation.field() == field)
                .findFirst()
                .map(annotation -> annotation.name());

        return optionalName.get();

    }
}
