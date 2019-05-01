import java.net.*;
public class ping {
public static void main(String[] args) throws Exception {
    InetAddress inet;

    inet = InetAddress.getByAddress(new byte[] { (byte)216,(byte)58,(byte)221,36 });
    System.out.println("Sending Ping Request to " + inet);
    System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
}
}
