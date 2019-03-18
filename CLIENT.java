import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class CLIENT {
    private Socket socket;
    private String IP;
    private int PORT;

    private DataInputStream din;
    private DataOutputStream dout;

    CLIENT(String IP, int PORT)
    {
        this.IP = IP;
        this.PORT = PORT;

        try {
            socket = new Socket(IP, PORT);
            System.out.println("Coneected....");

            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

            String msg = din.readUTF();
            System.out.println("Server : "+msg);

            dout.writeUTF("I am Client in java:(><:)");

            socket.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg)
    {
        new CLIENT("192.168.0.104",12345);
    }


}
