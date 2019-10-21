package ch07;

// 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할 수 없도록 제어자를 붙이고
// 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 getter, setter메서드 추가
class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	int prevChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void setChannel(int channel) {
		// 이전 채널의 값을 저장할 멤버변수 정의
		// 지정한 채널의 값을 channel에 넣기 전에 원래의 채널값을 prev에 저장
		prevChannel = this.channel;
		this.channel = channel;
	}
	int getChannel() {
		return channel;
	}
	void setVolume(int volume) {
		this.volume = volume;
	}
	int getVolume() {
		return volume;
	}
	
	// 이전 채널로 이동하는 기능의 메서드를 추가
	// (이전 채널의 값을 저장할 멤버변수를 정의해라)
	void gotoPrevChannel() {
		setChannel(prevChannel);
	}
	
}

public class Exercise7_11 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}
}
