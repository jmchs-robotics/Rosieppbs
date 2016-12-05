
package org.usfirst.frc5933.Rosieppbs;  

import java.io.IOException;  
import java.net.DatagramPacket;  
import java.net.DatagramSocket;  
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;  
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
	private InetAddress addr_;  
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
			addr_ = InetAddress.getByName(ip_);  
			//socket_.joinGroup(addr_);
			is_connected_ = true;
		} catch (UnknownHostException ex) {  
			return false;  
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
			socket_.receive(packet);  
			if (packet.getData().length > 0) {  
				// TODO: Parse the data and set the direction and degrees  
				
				String stuffInThePacket = new String (packet.getData(),0,packet.getLength());
				stuffInThePacket = stuffInThePacket.toLowerCase(); //standardize everything. Just in case.
				//read data
				
				
				//Array contains x position, y, width, distance, L/C/R 
				//e.g. -100.14,20.33,15.75,172.56,L
				String[] packetParsing = stuffInThePacket.split(","); //now is: {"-100.14","20.33","15.75","172.56","L"}
				
				//
				
				degrees_x = Double.parseDouble(packetParsing[0]);
				degrees_y = Double.parseDouble(packetParsing[1]);
				degrees_width = Double.parseDouble(packetParsing[2]);
				distance = Double.parseDouble(packetParsing[3]);
				
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
