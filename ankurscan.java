import java.net.*;
 
class PortScanner {
   public static void main(String []args) {
      for (int port = 1; port <= 65535; port++) {
         try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("208.91.198.227", port), 1000);
            socket.close();
            System.out.println("Port " + port + " is open");
        } catch (Exception ex) {
        }
      }
   }
}
