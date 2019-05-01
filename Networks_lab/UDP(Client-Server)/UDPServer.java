import java.io.*;
import java.net.*;
class UDPServer
{
	public static int fact(int n)
	{
		if(n == 0)
			return 1;
		else
			return (n*fact(n-1));
	}
	public static void main(String args[])throws IOException,NumberFormatException
	{
		int a=0;
		DatagramSocket sersock=new DatagramSocket(9876);
		byte[] receivedata=new byte[1024];
		byte[] senddata=new byte[1024];
		while(true)
		{
			DatagramPacket recpack=new DatagramPacket(receivedata,receivedata.length);
			sersock.receive(recpack);
			String sentence=new String(recpack.getData());
			System.out.println(sentence);
			try{
				a=Integer.parseInt(sentence.trim());
			}
			catch(Exception e)
			{
				System.out.println("Enter a number");
			}
			int result = fact(a);
			System.out.println("Received : "+ sentence);
			InetAddress IPA=recpack.getAddress();
			int port=recpack.getPort();
			sentence = Integer.toString(result);
			String csentence="Factorial of "+a+" is "+sentence;
			senddata =csentence.getBytes();
			DatagramPacket sendpack=new DatagramPacket(senddata,senddata.length,IPA,port);
			sersock.send(sendpack);
		}
	}
}
