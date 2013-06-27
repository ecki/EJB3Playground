package net.eckenfels.ejbtest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class NoIfStackTracer
 */
@Stateless(mappedName = "NoIfStackTracer")
@LocalBean
public class NoIfStackTracer
{
    /**
     * Default constructor. 
     */
    public NoIfStackTracer()
    {
        System.out.printf("NoIfStackTracer.<init> hash=%h%n", this);
    }
    
    public void throwEx()
    {
        throw new RuntimeException();
    }
}
