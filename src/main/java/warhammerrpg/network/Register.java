package warhammerrpg.network;

import com.esotericsoftware.kryo.Kryo;
import warhammerrpg.database.entity.Person;
import warhammerrpg.network.pack.*;

/**
 * All request and response object must be addObserver in Kryo object. See https://github.com/EsotericSoftware/kryonet#registering-classes
 */
public class Register {
    public void registerClasses(Kryo kryo) {
        kryo.register(PingPack.class);
        kryo.register(WelcomePack.class);
        kryo.register(WelcomeReplyPack.class);
        kryo.register(KickPack.class);
        kryo.register(Person.Field.class);
        kryo.register(ChangeDataEventPack.class);

    }
}
