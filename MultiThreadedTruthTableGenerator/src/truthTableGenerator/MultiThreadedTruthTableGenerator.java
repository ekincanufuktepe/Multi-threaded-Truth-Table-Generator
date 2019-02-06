package truthTableGenerator;

import java.math.BigInteger;

public class MultiThreadedTruthTableGenerator extends Thread {
	
	private BigInteger startAt;
	private BigInteger endAt;
	private BigInteger binaryString;
	
	
	public MultiThreadedTruthTableGenerator(BigInteger startAt, BigInteger endAt, BigInteger binaryString) {
		this.startAt = startAt;
		this.endAt = endAt;
		this.binaryString = binaryString;
	}
	
	@Override
	public void run() {
		try
        { 
//             Displaying the thread that is running 
            System.out.println ("Running Thread " + Thread.currentThread().getId());
            generate(startAt, endAt, this.binaryString);
            System.out.println("Running Thread " + Thread.currentThread().getId()+ "is complete..");
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
	}
	
	public void  generate(BigInteger low , BigInteger up, BigInteger na){
		if(low.compareTo(up) == 1) {
        	return;
        }
		
	    for (BigInteger i = low; i.compareTo(up) != 1; i=i.add(new BigInteger("1"))) {
	        String binaryRep = i.toString(2);
	        while (binaryRep.length() != na.intValue()) {
	            binaryRep = '0'+binaryRep;
	            if(binaryRep.length() > na.intValue()) {
	            	return;
	            }
	        }
	        // Uncomment the line below if you want to view the truth table
//	        System.out.println(binaryRep);
	        if(i.compareTo(up) == 1) {
	        	return;
	        }
	    }
	}

}
