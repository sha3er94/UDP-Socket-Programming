package socketprogrammingudp;
import java.io.*; 
import java.net.*; 
import java.util.Random;
import java.util.Scanner;
class SocketProgrammingUDP extends Thread {    
        public static String getport() throws InterruptedException{ 
            return server.getPort();
        }
	public static void main(String args[]) throws SocketException, UnknownHostException, IOException, InterruptedException   {  
             while(true)
     { 
                SocketProgrammingUDP client = new SocketProgrammingUDP();
                new Thread(client).start();
                
                String Port = "6789";
                System.out.println("Port Number : "+Port);
		BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in));  
                //Scanner inFromUser = new Scanner(System.in);
		DatagramSocket clientSocket = new DatagramSocket();       
		InetAddress IPAddress = InetAddress.getByName("localhost"); 
                 Random rand=new Random();
		byte[] sendData = new byte[1024]; 
                byte[] sendData2 = new byte[1024];
		byte[] receiveData = new byte[1024];
                System.out.println("The First Number IS :");
	        double number1= rand.nextInt(10);
                System.out.println(number1); 
                String num1= Double.toString(number1);
		System.out.println("The Second Number IS :");
                double number2 = rand.nextInt(10);
                System.out.println(number2); 
                String num2= Double.toString(number2);
                sendData=num1.getBytes();
                sendData2=num2.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(Port)); 
                DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress, Integer.parseInt(Port));
		clientSocket.send(sendPacket);
                clientSocket.send(sendPacket2);
                
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);       
		clientSocket.receive(receivePacket);       
		String modifiedSentence = new String(receivePacket.getData());       
		System.out.println("FROM SERVER:" + modifiedSentence);  
                thread2 c = new thread2("thread");
                 c.run();
                 c.start();
                clientSocket.close();  
        }
		} 
	}
