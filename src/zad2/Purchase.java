/**
 *
 *  @author Kryst Jakub PD3724
 *
 */

package zad2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

public class Purchase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PropertyChangeSupport chg = new PropertyChangeSupport(this);
	private VetoableChangeSupport veto = new VetoableChangeSupport(this);
	
	private String prod;
	private String data;
	private double price;
	
	public Purchase(String prod, String data, double price) {
		this.prod = prod;
		this.data = data;
		this.price = price;	
	}
	
	public Purchase() {
	}
	
	
	public String getProd() {
		return prod;
	}
	
	synchronized void setProd(String prod) {	
		this.prod = prod;
	}
	
	public String getData() {
		return data;
	}
	
    synchronized void setData(String newData) {	
    	String oldData = data;
		data = newData;
		chg.firePropertyChange("data", oldData, newData);
  	
	}
    
    public double getPrice() {
    	return price;
    }
    
    synchronized void setPrice(double newPrice)  throws PropertyVetoException {
    	
    	double oldPrice = price;
    	veto.fireVetoableChange("price", oldPrice, newPrice);
    	price = newPrice;
    	chg.firePropertyChange("price", oldPrice, newPrice);
    }
	
	

	
	
    public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
    	 chg.addPropertyChangeListener(l);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
    	 chg.removePropertyChangeListener(l);
    }
	
    
    public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
    	 veto.addVetoableChangeListener(l);
    }

    public synchronized void removeVetoableChangeListener(VetoableChangeListener l) {
    	 veto.removeVetoableChangeListener(l);
    }
    
    public String toString() {
    	return "Purchase [prod="+prod+", data="+data+", price="+price+"]";
    }

	
}  
