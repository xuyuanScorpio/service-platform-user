package com.service.platform.user.config;

import com.service.platform.user.facade.UserFacadeService;
import com.service.platform.user.facade.impl.UserFacadeServiceImpl;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThriftServer {

    private static final Logger logger = LoggerFactory.getLogger(ThriftServer.class);

    @Value("${thriftServer.port}")
    private int port;
    @Value("${thriftServer.minWorkerThreads}")
    private int minThreads;
    @Value("${thriftServer.maxWorkerThreads}")
    private int maxThreads;

    private TCompactProtocol.Factory protocolFactory;
    private TFramedTransport.Factory transportFactory;

    @Autowired
    private UserFacadeServiceImpl userFacadeServiceImpl;

    public void init() {
        protocolFactory = new TCompactProtocol.Factory();
        transportFactory = new TFramedTransport.Factory();
    }

    public void start() {

        UserFacadeService.Processor processor = new UserFacadeService.Processor<UserFacadeService.Iface>(userFacadeServiceImpl);
        init();
        try {
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(minThreads);
            tArgs.maxWorkerThreads(maxThreads);
            TServer server = new TThreadPoolServer(tArgs);
            logger.info("thrift服务启动成功, 端口={}", port);
            server.serve();
        } catch (Exception e) {
            logger.error("thrift服务启动失败", e);
        }

    }


}
