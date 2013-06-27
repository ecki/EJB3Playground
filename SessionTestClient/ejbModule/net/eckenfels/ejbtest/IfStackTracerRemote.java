package net.eckenfels.ejbtest;

import javax.ejb.Remote;

@Remote
public interface IfStackTracerRemote
{
    public void throwEx();
}
