package warhammerrpg.network;

import com.esotericsoftware.kryo.Kryo;
import junit.framework.TestCase;
import warhammerrpg.network.request.Ping;

public class RegisterTest extends TestCase {

    public void testRegisterClasses() throws Exception {
        Register register = new Register();

        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(true);
        register.registerClasses(kryo);

        assertNotNull(kryo.getRegistration(Ping.class));
    }

}