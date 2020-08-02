import Instance.SelectDao;
import ssh.*;


public class TLsampler {

    public static void main(String[] args) {
        String temp = null;

        //temp = SelectDao.getInstance().SYSDATE();

        System.out.println("SYSDATE CONNECTION TEST EXAMPLE##################");
        //System.out.println(temp);

        System.out.println("test start");
        GetBinary.getInstance().BinaryServer();


    }
}
