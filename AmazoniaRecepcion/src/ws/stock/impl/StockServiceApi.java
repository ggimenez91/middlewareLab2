/**
 * StockServiceApi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.stock.impl;

public interface StockServiceApi extends java.rmi.Remote {
    public ws.stock.impl.AnulacionReservaResponse anularReserva(java.lang.Long arg0) throws java.rmi.RemoteException;
    public ws.stock.impl.ReservaResponse reservarProducto(ws.stock.impl.Compra[] arg0) throws java.rmi.RemoteException;
}
