package warhammerrpg.network;

import com.esotericsoftware.kryo.Kryo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import warhammerrpg.network.pack.PingPack;

public class RegisterTest {

    @Test
    public void registerClasses() throws Exception {
        Register register = new Register();

        Kryo kryo = new Kryo();
        kryo.setRegistrationRequired(true);
        register.registerClasses(kryo);

        Assert.assertNotNull(kryo.getRegistration(PingPack.class));
    }

}