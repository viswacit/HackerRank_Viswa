package com.example.qlikmysql;

public class EnumEx {
	
	
	public enum Day
	{
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY;
	}
	
	private PizzaStatus status;
    
	public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }
 
    public boolean isDeliverable() {
        
        return false;
    }
 
    // Driver method
    public static void main(String[] args)
    {
        String str = "MONDAY";
    }

}
