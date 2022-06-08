package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class PriceLimitator implements VetoableChangeListener {

	private double min;
	
	
	PriceLimitator(double min) {
	this.min = min;	
	}
		
	
	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		// TODO Auto-generated method stub
		
		Double newVal = (Double) evt.getNewValue();

		if (newVal < min) 	   
			throw new PropertyVetoException("Price change to: "+newVal+" not allowed", evt);
		
	}

}
