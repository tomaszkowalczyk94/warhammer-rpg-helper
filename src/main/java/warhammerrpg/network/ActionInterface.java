package warhammerrpg.network;

import com.esotericsoftware.kryonet.Connection;
import warhammerrpg.network.pack.Pack;

public interface ActionInterface {

    Pack run(Pack request, Connection connection);

}
