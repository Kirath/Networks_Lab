import java.net.*;
import java.io.*;
 class SerTCP{
 public static void main(String args[])throws IOException{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 String data = br.readLine();
 try{
 ServerSocket s = new ServerSocket(1234);
 Socket skt = s.accept();
 System.out.println("Server connected");
 PrintWriter out = new PrintWriter(skt.getOutputStream(),true);
 System.out.println("Sending string \n"+data+"\n");out.print(data);
 out.close();
 skt.close();
 s.close();
 }
 catch(Exception e){
 System.out.println("whoops! didnot connect!\n");
 }
 }
 }
