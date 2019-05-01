import java.util.*;
import java.lang.*;
import java.net.*;
public class getRemoteIP
{
public static void main(String args[])
{
try
{
InetAddress IPO=InetAddress.getByName("bppimt.ac.in");
System.out.println("IP of this system = " +IPO);
}
catch(Exception e)
{
System.out.println("Exception caught = "+e.getMessage());
}
}
}
