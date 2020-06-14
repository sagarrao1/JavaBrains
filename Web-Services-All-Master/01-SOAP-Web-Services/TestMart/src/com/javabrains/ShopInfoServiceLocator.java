/**
 * ShopInfoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.javabrains;

public class ShopInfoServiceLocator extends org.apache.axis.client.Service implements com.javabrains.ShopInfoService {

    public ShopInfoServiceLocator() {
    }


    public ShopInfoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ShopInfoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ShopInfoPort
    private java.lang.String ShopInfoPort_address = "http://desktop-kobu9qu:8080/TestMart/ShopInfoService";

    public java.lang.String getShopInfoPortAddress() {
        return ShopInfoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ShopInfoPortWSDDServiceName = "ShopInfoPort";

    public java.lang.String getShopInfoPortWSDDServiceName() {
        return ShopInfoPortWSDDServiceName;
    }

    public void setShopInfoPortWSDDServiceName(java.lang.String name) {
        ShopInfoPortWSDDServiceName = name;
    }

    public com.javabrains.ShopInfo getShopInfoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ShopInfoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getShopInfoPort(endpoint);
    }

    public com.javabrains.ShopInfo getShopInfoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.javabrains.ShopInfoPortBindingStub _stub = new com.javabrains.ShopInfoPortBindingStub(portAddress, this);
            _stub.setPortName(getShopInfoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setShopInfoPortEndpointAddress(java.lang.String address) {
        ShopInfoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.javabrains.ShopInfo.class.isAssignableFrom(serviceEndpointInterface)) {
                com.javabrains.ShopInfoPortBindingStub _stub = new com.javabrains.ShopInfoPortBindingStub(new java.net.URL(ShopInfoPort_address), this);
                _stub.setPortName(getShopInfoPortWSDDServiceName());
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
        if ("ShopInfoPort".equals(inputPortName)) {
            return getShopInfoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://javabrains.com/", "ShopInfoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://javabrains.com/", "ShopInfoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ShopInfoPort".equals(portName)) {
            setShopInfoPortEndpointAddress(address);
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
