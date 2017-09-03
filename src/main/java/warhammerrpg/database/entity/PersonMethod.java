package warhammerrpg.database.entity;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PersonMethod{

    public enum Type {GETTER, SETTER};

    Person.Field forField();
    Type type();

}