package com.service.platform.user.thriftClient.domain;

import com.service.platform.user.facade.GenerateIdFacadeService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient {

    private GenerateIdFacadeService.Client  generateIdService;
    private TCompactProtocol protocol;
    private TTransport transport;
    private String host;
    private int port;
    private int timeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public GenerateIdFacadeService.Client getGenerateIdService() {
        return generateIdService;
    }

    public void init(){
        transport = new TSocket(host, port, timeout);
        transport = new TFramedTransport.Factory().getTransport(transport);
        protocol = new TCompactProtocol(transport);
        generateIdService = new GenerateIdFacadeService.Client(protocol);
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close(){
        transport.close();
    }

}
