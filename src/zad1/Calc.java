/**
 *
 *  @author Kryst Jakub PD3724
 *
 */

package zad1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;

public class Calc implements PropertyChangeListener {
private PropertyChangeSupport chg = new PropertyChangeSupport(this);
String op;	

	
synchronized void setOp(String newOp) {
	
	String oldOp = op;
	op = newOp;
	propertyChange.firePropertyChange("count", new String(oldOp),
            new String(newOp));
	
}
	
	
public String doCalc(String s) {
	
	String arg[] = s.split(" +");
	BigDecimal a = new BigDecimal(arg[0]);
	BigDecimal b = new BigDecimal(arg[2]);	
	op = arg[1];
	

	BigDecimal wyn = a.multiply(b);
		
	String wynik = wyn.toString();
	return wynik;
}






public BigDecimal sum(BigDecimal a, BigDecimal b) {
	return a.add(b);
	
}


public BigDecimal substract(BigDecimal a, BigDecimal b) {
	return a.subtract(b);
	
}


public BigDecimal multiply(BigDecimal a, BigDecimal b) {
	return a.multiply(b);
	
}


public BigDecimal divide(BigDecimal a, BigDecimal b) {
	return a.divide(b);
	
}


public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
	 chg.addPropertyChangeListener(l);
	 }

public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
	 chg.removePropertyChangeListener(l);
	 }



@Override
public void propertyChange(PropertyChangeEvent evt) {
	// TODO Auto-generated method stub
	
}

}  
