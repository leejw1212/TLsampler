package ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public interface Dao <T extends Vo> {

    //public static final String SSH_ID = "tibero";
    public static final String SSH_ID = "cntr";
    //public static final String SSH_PW = "1215";
    public static final String SSH_PW = "1215";
    //public static final String SSH_IP = "192.168.17.88";
    public static final String SSH_IP = "localhost";
    public static final int SSH_PORT = 22;

    default Session openSsh() throws Exception {
        JSch jsch = new JSch();

        Session session = jsch.getSession(SSH_ID, SSH_IP, SSH_PORT);
        session.setPassword(SSH_PW);

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");

        session.setConfig(config);
        session.connect();  //연결 시도
        System.out.println(session);

        return session;
    }

    default void closeSsh(Session session) {
        try {
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
