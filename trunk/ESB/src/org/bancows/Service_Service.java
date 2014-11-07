/**
 * Service_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bancows;

public interface Service_Service extends javax.xml.rpc.Service {
    public java.lang.String getServicePortAddress();

    public org.bancows.Service_PortType getServicePort() throws javax.xml.rpc.ServiceException;

    public org.bancows.Service_PortType getServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
