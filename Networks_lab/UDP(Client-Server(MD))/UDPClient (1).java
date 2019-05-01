import java.io.*;
import java.net.*;

class UDPClient
{
	public static void main(String args[])throws IOException
	{
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clisock=new DatagramSocket();
		InetAddress IPA=InetAddress.getByName("127.0.0.1");
		byte[] receivedata=new byte[1024];
		byte[] senddata=new byte[1024];
		String sentence=inFromUser.readLine();
		senddata =sentence.getBytes();
		DatagramPacket sendpack=new DatagramPacket(senddata,senddata.length,IPA,9876);
		clisock.send(sendpack);
		DatagramPacket recpack=new DatagramPacket(receivedata,receivedata.length);
		clisock.receive(recpack);
		String msentence=new String(recpack.getData());
		System.out.println("From Server : "+ msentence);
		clisock.close();
	}
}
