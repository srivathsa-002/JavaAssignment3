package Assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class Times {
	
	public ArrayList<Double> findTimes(ArrayList<String> pingLines){
		ArrayList<Double> pingTimes = new ArrayList<Double>();
		for(String s:pingLines) {
			int indexOfTime = s.indexOf("time=");
			int indexOfMs = s.indexOf("ms");
			if(indexOfTime != -1 && indexOfMs != -1) {
				String curTime = s.substring(indexOfTime + 5,indexOfMs);
				pingTimes.add(Double.parseDouble(curTime));
			}
		}
		return pingTimes;
	}
	
	public double findMedian(ArrayList<Double> pingTimes,int packets) {
		System.out.println("All Times:" + pingTimes);
		double median = 0.0;
		Collections.sort(pingTimes);
		if(packets % 2 == 0) {
            int mid1 = (packets/2)-1;
            int mid2 = packets/2;
            median = (pingTimes.get(mid1) + pingTimes.get(mid2))/2;
        }
        else {
            int mid = pingTimes.size()/2;
            median = pingTimes.get(mid);
        }
		return median;
	}
}
