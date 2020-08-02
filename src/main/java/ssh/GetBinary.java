package ssh;

import Instance.SelectDao;
import com.jcraft.jsch.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetBinary implements Dao<Vo> {

    private static GetBinary shell;

    public static GetBinary getInstance() {
        if (shell == null) {
            shell = new GetBinary();
        }
        return shell;
    }

    public void BinaryServer() {


        System.out.println("==> Connecting to" );
        Session session = null;
        Channel channel = null;

        // 2. 세션 객체를 생성한다 (사용자 이름, 접속할 호스트, 포트를 인자로 준다.)
        try {
            session = openSsh();
            // 5. 접속한다.

            // 6. sftp 채널을 연다.
            channel = session.openChannel("exec");

            // 8. 채널을 SSH용 채널 객체로 캐스팅한다
            ChannelExec channelExec = (ChannelExec) channel;

            System.out.println("==> Connected to" );

            channelExec.setCommand("ssh leejungwook@192.168.0.6");
            channelExec.connect();

            System.out.println("==> Connected to" );



        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
