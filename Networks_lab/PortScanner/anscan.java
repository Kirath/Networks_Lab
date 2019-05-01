import java.net.*;
public class anscan {
public static void main(String[] args) throws Exception {
	int count=0; 
    for(int i=0; i<=100;i++)
    {
    	try
    	{
    		Socket s=new Socket("208.91.198.227",i);
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

