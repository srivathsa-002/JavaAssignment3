package Assignment3;
import java.io.*;
import java.util.*;

public class Ping {
	private String host;
	private int packets;
	public Ping() {
		packets = 0;
		host = "";
	}
	
	public void setPackets(int packets) {
		this.packets = packets;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public ArrayList<String> hostPing() {
		ArrayList<String> pingLines = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec("ping -c " + packets + " " + host);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while((line = br.readLine()) != null) {
				pingLines.add(line);
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return pingLines;
	}
	
	public void printResults() {
		Times times = new Times();
		try {
			ArrayList<String> pingLines = hostPing();
            if(pingLines.size() == 1){
                System.out.println(host + " NOT FOUND!!");
            }
            else {
            	ArrayList<Double> pingTimes = times.findTimes(pingLines);
            	double median = times.findMedian(pingTimes,packets);
            	System.out.println("Median of all the ping times of " + host + " : " + median + " ms");
            }
		}
        catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public static void main(String args[]) {
		Ping ping = new Ping();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter host IP: ");
		String host = sc.next();
		ping.setHost(host);
		System.out.println("Enter number of Packets: ");
		int numOfPackets = sc.nextInt();
		ping.setPackets(numOfPackets);
		ping.printResults();
	}
}