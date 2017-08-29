package warhammerrpg.network;

import com.esotericsoftware.kryo.Kryo;
import warhammerrpg.network.pack.PingPack;
import warhammerrpg.network.pack.WelcomePack;
import warhammerrpg.network.pack.WelcomeReplyPack;

/**
 * All request and response object must be register in Kryo object. See https://github.com/EsotericSoftware/kryonet#registering-classes
 */
public class Register {
    public void registerClasses(Kryo kryo) {
        kryo.register(PingPack.class);
        kryo.register(WelcomePack.class);
        kryo.register(WelcomeReplyPack.class);
    }
}
