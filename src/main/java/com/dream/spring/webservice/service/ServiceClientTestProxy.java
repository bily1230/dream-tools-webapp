package com.dream.spring.webservice.service;

public class ServiceClientTestProxy implements com.dream.spring.webservice.service.ServiceClientTest {
  private String _endpoint = null;
  private com.dream.spring.webservice.service.ServiceClientTest serviceClientTest = null;
  
  public ServiceClientTestProxy() {
    _initServiceClientTestProxy();
  }
  
  public ServiceClientTestProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceClientTestProxy();
  }
  
  private void _initServiceClientTestProxy() {
    try {
      serviceClientTest = (new com.dream.spring.webservice.service.ServiceClientTestServiceLocator()).getServiceClientTestPort();
      if (serviceClientTest != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceClientTest)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceClientTest)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceClientTest != null)
      ((javax.xml.rpc.Stub)serviceClientTest)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dream.spring.webservice.service.ServiceClientTest getServiceClientTest() {
    if (serviceClientTest == null)
      _initServiceClientTestProxy();
    return serviceClientTest;
  }
  
  public java.lang.String getName(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serviceClientTest == null)
      _initServiceClientTestProxy();
    return serviceClientTest.getName(arg0);
  }
  
  
}