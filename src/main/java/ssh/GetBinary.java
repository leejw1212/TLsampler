package ssh;

import com.jcraft.jsch.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetBinary implements Dao<Vo> {

    private Object ChannelExec;

    public GetBinary() {

    }

    public void GetBinary() throws Exception {

        try {
            Session Local = openSsh();

            String command = "sftp binary@192.168.2.127";

            Channel BinaryServer = Local.openChannel("exec");
            ((ChannelExec) BinaryServer).setCommand(command);

            BinaryServer.setInputStream(null);
            ((ChannelExec) BinaryServer).setErrStream(System.err);

            InputStream in = BinaryServer.getInputStream();
            BinaryServer.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (BinaryServer.isClosed()) {
                    System.out.println("exit-status: " + BinaryServer.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            BinaryServer.disconnect();
            Local.disconnect();
            System.out.println("DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
