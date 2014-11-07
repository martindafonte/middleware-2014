/**
 * Service_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bancows;

public interface Service_PortType extends java.rmi.Remote {
    public void receive(long id, org.bancows.Transaction[] transaction) throws java.rmi.RemoteException;
}
