package warhammerrpg.database.entity;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PersonField {

    Person.Field field();
    String name() default "UNKNOWN";



}
