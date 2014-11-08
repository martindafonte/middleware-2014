/**
 * ServicePortBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bancows;

public class ServicePortBindingSkeleton implements org.bancows.Service_PortType, org.apache.axis.wsdl.Skeleton {
    private org.bancows.Service_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "transaction"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://bancows.org/", "transaction"), org.bancows.Transaction[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("receive", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName(Service_ServiceLocator.espacionombre, "receive"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("receive") == null) {
            _myOperations.put("receive", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("receive")).add(_oper);
    }

    public ServicePortBindingSkeleton() {
        this.impl = new org.bancows.ServicePortBindingImpl();
    }

    public ServicePortBindingSkeleton(org.bancows.Service_PortType impl) {
        this.impl = impl;
    }
    public void receive(long id, org.bancows.Transaction[] transaction) throws java.rmi.RemoteException
    {
        impl.receive(id, transaction);
    }

}
