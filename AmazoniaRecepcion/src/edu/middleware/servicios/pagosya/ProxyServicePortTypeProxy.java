package edu.middleware.servicios.pagosya;

public class ProxyServicePortTypeProxy implements edu.middleware.servicios.pagosya.ProxyServicePortType {
  private String _endpoint = null;
  private edu.middleware.servicios.pagosya.ProxyServicePortType proxyServicePortType = null;
  
  public ProxyServicePortTypeProxy() {
    _initProxyServicePortTypeProxy();
  }
  
  public ProxyServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initProxyServicePortTypeProxy();
  }
  
  private void _initProxyServicePortTypeProxy() {
    try {
      proxyServicePortType = (new edu.middleware.servicios.pagosya.PagosServiceLocator()).getPagosPort();
      if (proxyServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)proxyServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)proxyServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (proxyServicePortType != null)
      ((javax.xml.rpc.Stub)proxyServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.middleware.servicios.pagosya.ProxyServicePortType getProxyServicePortType() {
    if (proxyServicePortType == null)
      _initProxyServicePortTypeProxy();
    return proxyServicePortType;
  }
  
  public java.lang.Object invoke(java.lang.Object arg0) throws java.rmi.RemoteException{
    if (proxyServicePortType == null)
      _initProxyServicePortTypeProxy();
    return proxyServicePortType.invoke(arg0);
  }
  
  
}