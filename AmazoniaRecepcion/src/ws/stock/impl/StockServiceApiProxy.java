package ws.stock.impl;

public class StockServiceApiProxy implements ws.stock.impl.StockServiceApi {
  private String _endpoint = null;
  private ws.stock.impl.StockServiceApi stockServiceApi = null;
  
  public StockServiceApiProxy() {
    _initStockServiceApiProxy();
  }
  
  public StockServiceApiProxy(String endpoint) {
    _endpoint = endpoint;
    _initStockServiceApiProxy();
  }
  
  private void _initStockServiceApiProxy() {
    try {
      stockServiceApi = (new ws.stock.impl.StockServiceImplServiceLocator()).getStockServiceImplPort();
      if (stockServiceApi != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stockServiceApi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stockServiceApi)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stockServiceApi != null)
      ((javax.xml.rpc.Stub)stockServiceApi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.stock.impl.StockServiceApi getStockServiceApi() {
    if (stockServiceApi == null)
      _initStockServiceApiProxy();
    return stockServiceApi;
  }
  
  public ws.stock.impl.AnulacionReservaResponse anularReserva(java.lang.Long arg0) throws java.rmi.RemoteException{
    if (stockServiceApi == null)
      _initStockServiceApiProxy();
    return stockServiceApi.anularReserva(arg0);
  }
  
  public ws.stock.impl.ReservaResponse reservarProducto(ws.stock.impl.Compra[] arg0) throws java.rmi.RemoteException{
    if (stockServiceApi == null)
      _initStockServiceApiProxy();
    return stockServiceApi.reservarProducto(arg0);
  }
  
  
}