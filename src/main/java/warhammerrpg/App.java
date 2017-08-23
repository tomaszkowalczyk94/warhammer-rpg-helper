package warhammerrpg;

import warhammerrpg.network.Network;
import warhammerrpg.network.exception.NetworkException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NetworkException {

        Network network = new Network();
        network.runServer();

        System.out.println( "Hello World!" );
    }
}
