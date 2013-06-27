package net.eckenfels.ejbtest;

import javax.ejb.Local;

@Local
public interface IfStackTracerLocal
{
    public void throwEx();
}
