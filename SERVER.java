import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class SERVER {

    private ServerSocket serverSocket;
    private String IP;
    private int PORT;

    private DataOutputStream dout;
    private DataInputStream din;


    SERVER(String IP, int PORT)
    {
        this.IP = IP;
        this.PORT = PORT;

        try {
            serverSocket = new ServerSocket(PORT);

            //For server having more than one IP addresses....
            //serverSocket = new ServerSocket();
            //serverSocket.bind(new InetSocketAddress(InetAddress.getByAddress(new byte[]{0,0,0,0}),PORT ));

            Socket client = serverSocket.accept();

            System.out.println("Client connected.."+client);

            dout = new DataOutputStream(client.getOutputStream());
            din = new DataInputStream(client.getInputStream());


            dout.writeUTF("HELLO CLIENT!");

            String msg = din.readLine();
            System.out.println("CLient :"+msg);

            client.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String []args)
    {
        new SERVER("!27.0.0.1",12345);
    }
}


