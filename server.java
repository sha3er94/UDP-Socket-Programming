package socketprogrammingudp;
import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class server extends Thread { 
    private static String Port;
    
    public static void setPort(String Port) {
        server.Port = Port;
    }

    public static String getPort() {
        return Port;
    }

    public server() {
    }
    public server(int port) throws IOException
   {
       ServerSocket serverSocket;
       serverSocket = new ServerSocket(port);
       serverSocket.setSoTimeout(100000);
    }
    public static boolean isNumeric(String s) {  
                return s.matches("[-+]?\\d*\\.?\\d+");  
                }
	public static void main(String args[]) throws Exception {  
               
                Scanner s = new Scanner (System.in);
                System.out.println("Enter Port Number : ");
                Port = s.next();
                while(isNumeric(Port)==false || Integer.parseInt(Port)<0){
                    System.out.println("Incorrect Port Number");
                    System.out.println("Please Enter Valid Port Number");
                    Port = s.next();
                }
                    setPort(Port);
                    //server Server=new server(Integer.parseInt(Port));
                    //System.out.println(getPort());
                    while(true){
                    DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(Port));             
		byte[] receiveData = new byte[1024];
                byte[] receiveData2 = new byte[1024]; 
		byte[] sendData = new byte[1024];             
		while(true)  {                  
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);                   
			serverSocket.receive(receivePacket);   
                        DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData.length);                   
			serverSocket.receive(receivePacket2);
			String num1 = new String(receivePacket.getData());
                        String num2 = new String(receivePacket2.getData());
			System.out.println("RECEIVED: " + num1);
                        System.out.println("RECEIVED 2: " + num2);
                        double number1 = Double.parseDouble(num1);
                        System.out.println("Number 1 : "+number1);
                        double number2 = Double.parseDouble(num2);
                        System.out.println("Number 2 : "+number2);
                        double sum = number1+number2;
                        System.out.println("Sum : "+sum);
                        String capitalizedSentence = ""+sum;
			InetAddress IPAddress = receivePacket.getAddress();                   
			int port = receivePacket.getPort();
                        System.out.println("port 1 : "+port);
                        try
                           {
                        Thread t = new server(port);
                        t.start();
                        }
                        catch(IOException e)
                        {
                             e.printStackTrace();
                        }
                        //InetAddress IPAddress2 = receivePacket2.getAddress();
			sendData = capitalizedSentence.getBytes();                   
			DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress, port);                   
			serverSocket.send(sendPacket);                
			}       
		} 
        }
    
	} 
