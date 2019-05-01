import java.net.*;
import java.io.*;
class Client{
public static void main (String args[]){
try{
Socket skt = new Socket("127.0.0.1",1234);

BufferedReader in = new BufferedReader (new InputStreamReader(skt.getInputStream()));
System.out.println("Recieved String:");
while(!in.ready()){

}
System.out.println(in.readLine());
System.out.println("\n");

}
catch(Exception e){
System.out.println("Whoops!It didnot work!\n");
}
}
}
