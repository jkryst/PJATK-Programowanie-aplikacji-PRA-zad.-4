package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PurchaseChange implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		Object oldVal = evt.getOldValue();
		Object newVal = evt.getNewValue();
		System.out.println("Change value of: "+evt.getPropertyName()+" from: "+ oldVal + " to: " + newVal);
		
	}

}
