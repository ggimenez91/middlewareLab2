/**
 * PagosServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.middleware.servicios.pagosya;

public class PagosServiceLocator extends org.apache.axis.client.Service implements edu.middleware.servicios.pagosya.PagosService {

    public PagosServiceLocator() {
    }


    public PagosServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PagosServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PagosPort
    private java.lang.String PagosPort_address = "http://localhost:8081/PagosYa/Pagos/Pagos/pagos";

    public java.lang.String getPagosPortAddress() {
        return PagosPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PagosPortWSDDServiceName = "PagosPort";

    public java.lang.String getPagosPortWSDDServiceName() {
        return PagosPortWSDDServiceName;
    }

    public void setPagosPortWSDDServiceName(java.lang.String name) {
        PagosPortWSDDServiceName = name;
    }

    public edu.middleware.servicios.pagosya.ProxyServicePortType getPagosPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PagosPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPagosPort(endpoint);
    }

    public edu.middleware.servicios.pagosya.ProxyServicePortType getPagosPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.middleware.servicios.pagosya.PagosServiceSoapBindingStub _stub = new edu.middleware.servicios.pagosya.PagosServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPagosPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPagosPortEndpointAddress(java.lang.String address) {
        PagosPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.middleware.servicios.pagosya.ProxyServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.middleware.servicios.pagosya.PagosServiceSoapBindingStub _stub = new edu.middleware.servicios.pagosya.PagosServiceSoapBindingStub(new java.net.URL(PagosPort_address), this);
                _stub.setPortName(getPagosPortWSDDServiceName());
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
        if ("PagosPort".equals(inputPortName)) {
            return getPagosPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios.middleware.edu/pagosya", "PagosService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios.middleware.edu/pagosya", "PagosPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PagosPort".equals(portName)) {
            setPagosPortEndpointAddress(address);
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
