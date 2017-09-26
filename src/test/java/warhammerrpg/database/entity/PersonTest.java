package warhammerrpg.database.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PersonTest {

    Person person;

    @Parameterized.Parameter(value = 0)
    public Person.Field field;

    @Parameterized.Parameter(value = 1)
    public Object fieldValue;

    @Parameterized.Parameter(value = 2)
    public String fieldName;

    public PersonTest() {
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Person.Field.NAME, "Alex", "imię" },
                {Person.Field.CUR_CAREER, new Career(), "obecna profesja" },
                {Person.Field.SPECIAL_SIGNS, "test xxx", "znaki szczególne" }
        });
    }

    @Test
    public void testGetAndSetField() throws Exception {
        person = new Person();
        person.setField(field, fieldValue);

        assertEquals(person.getField(field), fieldValue);
    }

    @Test
    public void testGetNameField() throws Exception {
        person = new Person();
        assertEquals(fieldName, person.getNameField(field));

    }

}