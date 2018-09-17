/**
 * ServiceClientTestService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dream.spring.webservice.service;

public interface ServiceClientTestService extends javax.xml.rpc.Service {
    public java.lang.String getServiceClientTestPortAddress();

    public com.dream.spring.webservice.service.ServiceClientTest getServiceClientTestPort() throws javax.xml.rpc.ServiceException;

    public com.dream.spring.webservice.service.ServiceClientTest getServiceClientTestPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
