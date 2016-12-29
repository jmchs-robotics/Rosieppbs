
package org.usfirst.frc5933.Rosieppbs;  

import java.io.IOException;  
import java.net.DatagramPacket;  
import java.net.DatagramSocket;  
import java.net.InetAddress;
import java.net.UnknownHostException;  

public class Helmsman {  

	public static final String NADA = "nada";  
	public static final String RIGHT = "right";  
	public static final String LEFT = "left";  

	private String ip_;  
	private int port_;  
	private boolean is_connected_ = false;  
	private byte[] data_ = new byte[1024];  
	private DatagramSocket socket_;  
	private String direction_ = new String();  
	private double degrees_x = 0;
	private double degrees_y = 0;
	private double degrees_width = 0;
	private double distance = 0;
	
	public Helmsman(String ip, int port) {  
		ip_ = ip;  
		port_ = port;  
	}  

	public boolean connect() {  
		try {  
			socket_ = new DatagramSocket(port_);  
			socket_.setSoTimeout(5);  
			//InetAddress.getByName(ip_);  
			is_connected_ = true;
		//} catch (UnknownHostException ex) {  
		//	return false; 
		} catch (IOException ex) {  
			return false;  
		}  
		return true;  
	}  

	public boolean is_connected() {  
		return is_connected_;  
	}  

	public boolean recv() {  
		DatagramPacket packet = new DatagramPacket(data_, data_.length);//, addr_, port_);  
		try {  
			packet.setLength(data_.length);
			System.out.println("I made it to the socket.recieve");
			socket_.receive(packet);  
			System.out.println("I have proceeded past socket.recieve");
			if (packet.getData().length > 0) {  
				// TODO: Parse the data and set the direction and degrees  
				
				String stuffInThePacket = new String (packet.getData(),0,packet.getLength());
				//String contains: x position, y, width, distance, L/C/R 
				//e.g. "-100.14,20.33,15.75,172.56,L "
				stuffInThePacket = stuffInThePacket.toLowerCase(); //standardize everything. Just in case.
				
				System.out.println("Stuff in the packet is: " + stuffInThePacket);
				//now is "-100.14,20.33,15.75,172.56,l "
				String[] packetParsing = stuffInThePacket.split(","); //now is: {"-100.14","20.33","15.75","172.56","l "}
				
				int count = 0; //keep track of the index in the for loop below
				for (String x : packetParsing){
					packetParsing[count] = x.trim(); //take the spaces out. just in case.
					count ++; //increment the index
				}
				//now is: {"-100.14","20.33","15.75","172.56","l"} Look at the last index for the difference
				
				degrees_x = Double.parseDouble(packetParsing[0]); //following example, is -100.14
				degrees_y = Double.parseDouble(packetParsing[1]); //is 20.33
				degrees_width = Double.parseDouble(packetParsing[2]); //is 15.75
				distance = Double.parseDouble(packetParsing[3]); //is 172.56
				
				if (packetParsing[4] == "l") {
					direction_ = LEFT; 

				} else if (packetParsing[4] == "r") {
					direction_ = RIGHT; 
					
				} else if (packetParsing[4] == "c") {
					direction_ = NADA; 
					
				} else {
				    System.err.println("My mayonnaise went bad!! :(");
				}
				
				return true;
				//System.out.println("Done got that data! " + stuffInThePacket);
			}  
		} catch (Exception e) {  
		    System.err.println(e);
			return false;  
		}  
		return false;  
	}  

	
	//the below methods are the easiest way to access the data that was grabbed from the string below
	public String get_direction() {  
		String tmp = direction_;  
		direction_ = NADA;  
		return tmp;  
	}  
	
	public double get_degrees_x() {  
		double tmp = degrees_x;  
		degrees_x = 0;  
		return tmp;  
	}
	
	public double get_degrees_y() {  
		double tmp = degrees_y;  
		degrees_y = 0;  
		return tmp;  
	}
	
	public double get_width() {  
		double tmp = degrees_width;  
		degrees_width = 0;  
		return tmp;  
	}
	
	public double get_distance() {  
		double tmp = distance;  
		distance = 0;  
		return tmp;  
	}
} 
