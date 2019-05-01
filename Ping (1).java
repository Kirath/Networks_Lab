import java.net.*;
import java.io.*;
public class Ping
{
public static void main(String args[])
{
System.out.println("Pinging status");
String ipa="192.168.4.9";
try
{
InetAddress IPA=InetAddress.getByName("192.168.4.9");
System.out.println("Sending ping request to " +ipa);
boolean status=IPA.isReachable(50000);
if(status)
{
System.out.println("Status : Host is reachable");
}
else
{
System.out.println("Status : Host is not reachable");
}
}catch(IOException e)
{
System.out.println("Host does not exist");
}
}
}
