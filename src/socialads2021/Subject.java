package socialads2021;

public interface Subject {
	public void attach(Observer observer);
	public void detach(Observer observer);
	public boolean notify(Advertisement ad);
}
