package service.platform.user;


import com.service.platform.user.domain.request.UserRequest;
import com.service.platform.user.facade.UserFacadeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class UserTest {

    private static TTransport transport = new TSocket("localhost", 9010, 300000);

    public static void main(String[] args) {

        try {
            UserFacadeService.Client client = init();

            UserRequest userRequest = new UserRequest();
            userRequest.setPassword(DigestUtils.md5Hex("111"));
            userRequest.setMobile("13766667777");

            System.out.println("远程调用服务：" + client.userRegister(userRequest));
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }


    }

    public static UserFacadeService.Client init(){
        UserFacadeService.Client client = null;
        try {

            transport = new TFramedTransport.Factory().getTransport(transport);

            TCompactProtocol protocol = new TCompactProtocol(transport);
            client = new UserFacadeService.Client(protocol);
            transport.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public static void destroy(){

        transport.close();

    }





}
