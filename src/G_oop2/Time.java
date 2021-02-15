package G_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;
	
	//get : 파라미터 값을 불러오는 것 | set : 파라미터의 값을 변수에 저장하는 것
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour < 0){
			hour += 24;
		}else if (hour >= 24){
			hour -= 24;
		}
		this.hour = hour;
	}
	
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0){
			hour -= 1;
			minute += 60;
		}else if (minute >= 60){
			hour += 1;
			minute -= 60;
		}
		this.minute = minute;
	}
	
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second < 0){
			minute -= 1;
			second += 60;
		}else if (second >= 60){
			minute += 1;
			second -= 60;
		}
		this.second = second;
	}
	
	String getTime(){
		if (hour < 10){
			return "0" + hour + ":" + minute + ":" + second;
		}
		if (minute < 10){
			return hour + ":0" + minute + ":" + second;
		}
		if (second < 10){
			return hour + ":" + minute + ":0" + second;
		}
		return hour + ":" + minute + ":" + second;
	}

	//시간을 실시간동안 흐르게 해주기 위한 메소드
	void clock(){
		while(true){
			System.out.println(getTime());
			stop(1000); //1초동안 멈춤
			setSecond(second + 1);
		}
	}
	
	//try catch : 예외처리
	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
