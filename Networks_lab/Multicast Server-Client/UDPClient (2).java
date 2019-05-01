import java.io.*;
import java.net.*;
class UDPClient
{
	public static void main(String args[])throws IOException
	{
		
		String INET_ADDR = "224.0.0.3";
                int PORT = 8800;
                MulticastSocket ms = new MulticastSocket(PORT);

		InetAddress IPA=InetAddress.getByName(INET_ADDR);
		ms.joinGroup(IPA);
		byte[] receivedata=new byte[1024];
		byte[] senddata=new byte[1024];

		DatagramPacket recpack=new DatagramPacket(receivedata,receivedata.length);
		ms.receive(recpack);
		String msentence=new String(recpack.getData());
		System.out.println("From Server : "+ msentence);
		ms.leaveGroup(IPA);
	}
}
