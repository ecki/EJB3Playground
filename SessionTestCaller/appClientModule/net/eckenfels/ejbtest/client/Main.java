package net.eckenfels.ejbtest.client;

import java.util.Hashtable;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.eckenfels.ejbtest.IfStackTracerRemote;

public class Main
{
    public static void main(String[] args) throws NamingException
    {
        System.out.println("First Lookup");
        IfStackTracerRemote ejb = lookup();
        try { ejb.throwEx(); } catch (EJBException e) { System.out.println("e="+e); }
        try { ejb.throwEx(); } catch (EJBException e) { System.out.println("e="+e); }
        try { ejb.throwEx(); } catch (EJBException e) { System.out.println("e="+e); }
        System.out.println("Second Lookup");
        ejb = lookup();
        try { ejb.throwEx(); } catch (EJBException e) { System.out.println("e="+e); }
        try { ejb.throwEx(); } catch (EJBException e) { System.out.println("e="+e); }
        try { ejb.throwEx(); } catch (EJBException e) { System.out.println("e="+e); }
    }

    private static IfStackTracerRemote lookup() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        final String appName = "SessionTestEAR";
        final String moduleName = "SessionTest";
        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
        // our EJB deployment, so this is an empty string
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = "IfStackTracer"; 
        // the remote view fully qualified class name
        final String viewClassName = IfStackTracerRemote.class.getName();
        // let's do the lookup
        return (IfStackTracerRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);    
    }
}
