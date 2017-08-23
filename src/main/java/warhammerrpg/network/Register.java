package warhammerrpg.network;

import com.esotericsoftware.kryo.Kryo;
import warhammerrpg.network.request.PingRequest;

/**
 * All request and response object must be register in Kryo object. See https://github.com/EsotericSoftware/kryonet#registering-classes
 */
class Register {
    public void registerClasses(Kryo kryo) {
        kryo.register(PingRequest.class);
    }
}
