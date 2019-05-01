import java.net.*;
public class anscan {
public static void main(String[] args) throws Exception {
	int count=0; 
    for(int i=0; i<=65535;i++)
    {
    	try
    	{
    		ServerSocket a=new ServerSocket(9999);
    		Socket sh=a.accept();
    		Socket s=new Socket("127.0.0.1",i);
    		System.out.println("The port "+i+" is busy");
    	}
    	catch(Exception e)
    	{
    		count++;
    	}

    }
        System.out.println();
    	System.out.println();
    	System.out.println(count+" are not busy");
}
}

