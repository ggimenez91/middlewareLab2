/**
 * StockServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.stock.impl;

public class StockServiceImplServiceLocator extends org.apache.axis.client.Service implements ws.stock.impl.StockServiceImplService {

    public StockServiceImplServiceLocator() {
    }


    public StockServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StockServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StockServiceImplPort
    private java.lang.String StockServiceImplPort_address = "http://localhost:8080/AmazoniaStockService/services/stockservice";

    public java.lang.String getStockServiceImplPortAddress() {
        return StockServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StockServiceImplPortWSDDServiceName = "StockServiceImplPort";

    public java.lang.String getStockServiceImplPortWSDDServiceName() {
        return StockServiceImplPortWSDDServiceName;
    }

    public void setStockServiceImplPortWSDDServiceName(java.lang.String name) {
        StockServiceImplPortWSDDServiceName = name;
    }

    public ws.stock.impl.StockServiceApi getStockServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StockServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStockServiceImplPort(endpoint);
    }

    public ws.stock.impl.StockServiceApi getStockServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.stock.impl.StockServiceImplServiceSoapBindingStub _stub = new ws.stock.impl.StockServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getStockServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStockServiceImplPortEndpointAddress(java.lang.String address) {
        StockServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.stock.impl.StockServiceApi.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.stock.impl.StockServiceImplServiceSoapBindingStub _stub = new ws.stock.impl.StockServiceImplServiceSoapBindingStub(new java.net.URL(StockServiceImplPort_address), this);
                _stub.setPortName(getStockServiceImplPortWSDDServiceName());
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
        if ("StockServiceImplPort".equals(inputPortName)) {
            return getStockServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.stock.ws/", "StockServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.stock.ws/", "StockServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StockServiceImplPort".equals(portName)) {
            setStockServiceImplPortEndpointAddress(address);
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
