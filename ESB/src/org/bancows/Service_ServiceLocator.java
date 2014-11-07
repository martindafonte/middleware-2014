/**
 * Service_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bancows;

public class Service_ServiceLocator extends org.apache.axis.client.Service implements org.bancows.Service_Service {

    public Service_ServiceLocator() {
    }


    public Service_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Service_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicePort
    private java.lang.String ServicePort_address = "http://localhost:8080/BancoWS/Service";

    public java.lang.String getServicePortAddress() {
        return ServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicePortWSDDServiceName = "ServicePort";

    public java.lang.String getServicePortWSDDServiceName() {
        return ServicePortWSDDServiceName;
    }

    public void setServicePortWSDDServiceName(java.lang.String name) {
        ServicePortWSDDServiceName = name;
    }

    public org.bancows.Service_PortType getServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicePort(endpoint);
    }

    public org.bancows.Service_PortType getServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bancows.ServicePortBindingStub _stub = new org.bancows.ServicePortBindingStub(portAddress, this);
            _stub.setPortName(getServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicePortEndpointAddress(java.lang.String address) {
        ServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bancows.Service_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bancows.ServicePortBindingStub _stub = new org.bancows.ServicePortBindingStub(new java.net.URL(ServicePort_address), this);
                _stub.setPortName(getServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicePort".equals(inputPortName)) {
            return getServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bancows.org/", "Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bancows.org/", "ServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicePort".equals(portName)) {
            setServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
