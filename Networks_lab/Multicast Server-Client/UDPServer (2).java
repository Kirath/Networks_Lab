import java.io.*;
import java.net.*;
class UDPServer
{
	
	public static void main(String args[])throws IOException,NumberFormatException
	{
	         String INET_ADDR = "224.0.0.3";
                 int PORT = 8800;
		
		DatagramSocket sersock=new DatagramSocket(PORT);
		byte[] receivedata=new byte[1024];
		byte[] senddata=new byte[1024];
		while(true)
		{
			
			InetAddress IPA=InetAddress.getByName(INET_ADDR);
			String sentence = "Pakistani website will be hacked by me soon - Anonymous Alpha 404";
			String csentence=sentence;
			senddata =csentence.getBytes();
			DatagramPacket sendpack=new DatagramPacket(senddata,senddata.length,IPA,8888);
			sersock.send(sendpack);
		}
	}
}
