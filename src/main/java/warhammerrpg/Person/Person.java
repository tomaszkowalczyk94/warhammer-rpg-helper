package warhammerrpg.Person;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Person {
    private enum Breed { Brak,Człowiek,Elf,Krasnolud}

    public Person(String name, Breed breed, String curProffesion, Integer age, String sex, String birthPlace, BigDecimal gold) {
        this.name = name;
        this.breed = breed;
        this.curProffesion = curProffesion;
        this.prevProffesion = "";
        this.age = age;
        this.eyesColour = "";
        this.hairColour = "";
        this.starSign = "";
        this.sex = sex;
        this.weight = 0.0;
        this.height = 0.0;
        this.siblings = "";
        this.birthPlace = birthPlace;
        this.specialSigns = "";
        this.gamerName = "";
        this.gameNaster = "";
        this.campaign = "";
        this.campaignYear = 0;
        this.expPresent = BigInteger.valueOf(0);
        this.expAll =  BigInteger.valueOf(0);
        this.move = 0;
        this.attackRun = 0;
        this.run = 0;
        this.head = 0;
        this.body = 0;
        this.rightHand = 0;
        this.leftHand = 0;
        this.rightLeg = 0;
        this.leftLeg = 0;
        this.gold = gold;
        this.silver = BigDecimal.valueOf(0);
        this.brass =  BigDecimal.valueOf(0);

    }

    //bohater
    private String name;
    private Breed breed;
    private String curProffesion;
    private String prevProffesion;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
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




    //opis bohatera
    private Integer age;
    private String eyesColour;
    private String hairColour;
    private String starSign;
    private String sex;
    private Double weight;
    private Double height;
    private String siblings;
    private String birthPlace;
    private String specialSigns;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
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



    ///Gracz
    private String gamerName;
    private String gameNaster;
    private String campaign;
    private Integer campaignYear;


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




    ///Punkty Doswiadczenia
    private BigInteger expPresent;
    private BigInteger expAll;

    public BigInteger getExpPresent() {
        return expPresent;
    }

    public void setExpPresent(BigInteger expPresent) {
        this.expPresent = expPresent;
    }

    public BigInteger getExpAll() {
        return expAll;
    }

    public void setExpAll(BigInteger expAll) {
        this.expAll = expAll;
    }



    ///Ruch w walce
    private Integer move;
    private Integer attackRun; ///Szarża
    private Integer run;

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




    ///Obrazek - Punkty Zbroi
    private Integer head;
    private Integer body;
    private Integer rightHand;
    private Integer leftHand;
    private Integer rightLeg;
    private Integer leftLeg;

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


    ///pieniądze
    private BigDecimal gold;
    private BigDecimal silver;
    private BigDecimal brass;  ///mosiądź

    public BigDecimal getGold() {
        return gold;
    }

    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    public BigDecimal getSilver() {
        return silver;
    }

    public void setSilver(BigDecimal silver) {
        this.silver = silver;
    }

    public BigDecimal getBrass() {
        return brass;
    }

    public void setBrass(BigDecimal brass) {
        this.brass = brass;
    }




/* test obiektu
    public static void main(String args[])
    {
        Person obj = new Person ("wojtek",Breed.Elf,"Mag",22,"M","Miejsce",BigDecimal.valueOf(200));
        System.out.println(obj.name);
        obj.setBody(32);
        System.out.println("Body="+obj.getBody());
        System.out.println("Exp="+obj.getExpPresent());
        System.out.println("Gold="+obj.getGold());
    }
*/
}
