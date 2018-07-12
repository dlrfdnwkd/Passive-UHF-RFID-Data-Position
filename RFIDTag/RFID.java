import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RFID {
	private String ID;
	private int rssi;
	private LocalDateTime identifiedTime;
	private int time;
	private ArrayList<Integer> rssiArray = new ArrayList<Integer>();
	private ArrayList<Integer> timeArray = new ArrayList<Integer>();
	private int count;
	private int deviation;
	private double x;
	private double y;
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getID() {
		return ID;
	}
	public void setRssi(int rssi) {
		rssiArray.add(rssi);
		for(int i=0;i<rssiArray.size();i++) {
			this.rssi += rssiArray.get(i);
		}
		this.rssi /= rssiArray.size();
		for(int i=0;i<rssiArray.size();i++) {
			deviation += (int) Math.pow(rssiArray.get(i)-this.rssi, 2);
		}
		deviation /= rssiArray.size();
		deviation = (int) Math.sqrt(deviation);
		count++;
	}
	public int getRssi() {
		return rssi;
	}
	public void setIdentifiedTime(LocalDateTime identifiedTime) {
		if(this.identifiedTime==null) {
			this.identifiedTime =  identifiedTime;
		}else {
			Duration duration = Duration.between(this.identifiedTime, identifiedTime);
			this.identifiedTime = identifiedTime;
			timeArray.add(duration.getNano());
			for(int i=0;i<timeArray.size();i++) {
				time = timeArray.get(i);
			}
			time /= timeArray.size();
		}
		
	}
	public LocalDateTime getIdentifiedTime() {
		return identifiedTime;
	}
	public int getTime() {
		return time;
	}
	public int getCount() {
		return count;
	}
	public int getDeviation() {
		return deviation;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getY() {
		return y;
	}
}
