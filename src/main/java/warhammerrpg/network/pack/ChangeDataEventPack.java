package warhammerrpg.network.pack;

import warhammerrpg.database.entity.Person;
import warhammerrpg.network.pack.AbstractPack;
import warhammerrpg.network.pack.Pack;

public class ChangeDataEventPack extends AbstractPack implements Pack {

    public Person.Field updatedField;

    public String oldValue;
    public String newValue;

}
