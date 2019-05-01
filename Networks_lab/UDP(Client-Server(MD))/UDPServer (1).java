import java.io.*;
import java.net.*;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
class UDPServer
{
	    public static String getMd5(String input) 
	    { 
		try {
		    MessageDigest md = MessageDigest.getInstance("MD5"); 
		    byte[] messageDigest = md.digest(input.getBytes()); 
		    BigInteger no = new BigInteger(1, messageDigest); 
		    String hashtext = no.toString(16); 
		    while (hashtext.length() < 32) { 
		        hashtext = "0" + hashtext; 
		    } 
		    return hashtext; 
		}
		catch (NoSuchAlgorithmException e) { 
		    throw new RuntimeException(e); 
		} 
	    } 
	  /*  //Caeser cipher
	public static StringBuffer encrypt(String text, int s) 
        { 
        StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97); 
                result.append(ch); 
            } 
        } 
        return result; 
       } 	
       */
           
	public static void main(String args[])throws IOException,NumberFormatException
	{
		//String a="";
		DatagramSocket sersock=new DatagramSocket(9876);
		byte[] receivedata=new byte[1024];
		byte[] senddata=new byte[1024];
		while(true)
		{
			DatagramPacket recpack=new DatagramPacket(receivedata,receivedata.length);
			sersock.receive(recpack);
			String sentence=new String(recpack.getData());
			System.out.println(sentence);
			//a = sentence;
			/*try{
				a=Integer.parseInt(sentence.trim());
			}
			catch(Exception e)
			{
				System.out.println("Enter a number");
			}*/
			String result = getMd5(sentence);
			System.out.println("Received : "+ sentence);
			InetAddress IPA=recpack.getAddress();
			int port=recpack.getPort();
			sentence = result;
			String csentence="MD5 encryption is "+sentence;
			senddata =csentence.getBytes();
			DatagramPacket sendpack=new DatagramPacket(senddata,senddata.length,IPA,port);
			sersock.send(sendpack);
		}
	}
}
