/**
 * PagosService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.middleware.servicios.pagosya;

public interface PagosService extends javax.xml.rpc.Service {
    public java.lang.String getPagosPortAddress();

    public edu.middleware.servicios.pagosya.ProxyServicePortType getPagosPort() throws javax.xml.rpc.ServiceException;

    public edu.middleware.servicios.pagosya.ProxyServicePortType getPagosPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
