import java.util.List;
import java.util.ArrayList;

public class Loan implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	
	private String bankName;
	private double interest;

	public void setInterest(double interest) {
		this.interest = interest;
		notifyObservers();	
	}

	public Loan (String bankName, double interest) {
		this.bankName = bankName;
		this.interest = interest;	
	}

	public boolean registerObserver(Observer observer) {
		boolean result = false;
		if(observer != null) {
			if(!observers.contains(observer)){
				observers.add(observer);	
			}
		}
		return result;
	}

	public boolean removeObserver(Observer observer) {
		boolean result = false;
		if(observer != null) {
			if(observers.contains(observer)) {
				observers.remove(observer);
				result = true;
			}
		}	
		return result;
	}

	public void notifyObservers () {
		for (Observer observer : observers ) {
			System.out.println("Notifying observers");
			observer.update(this.interest);
		}
	}

}