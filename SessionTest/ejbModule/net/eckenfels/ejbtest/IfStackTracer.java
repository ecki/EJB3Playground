package net.eckenfels.ejbtest;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class IfStackTracer
 */
@Stateless
public class IfStackTracer implements IfStackTracerRemote, IfStackTracerLocal {

    /**
     * Default constructor. 
     */
    public IfStackTracer()
    {
        System.out.printf("IfStackTracer.<init> hash=%h%n", this);
    }

    @Override
    public void throwEx() {
        throw new RuntimeException();
    }

}
