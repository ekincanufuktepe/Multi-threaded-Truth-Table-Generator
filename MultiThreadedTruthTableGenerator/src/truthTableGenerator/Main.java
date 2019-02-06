package truthTableGenerator;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {

		// Change only the two parameters below
		BigInteger binaryStringSize = new BigInteger("50");
		BigInteger numberOfThreads = new BigInteger("4");
		
		BigInteger binary = new BigInteger("2");
		int exponent = binaryStringSize.intValue();
		
		BigInteger partition = new BigInteger(binary.pow(exponent).divide(numberOfThreads).toString());	
		BigInteger endAt = new BigInteger(partition.toString());
		BigInteger startAt = new BigInteger("0");
		BigInteger i = new BigInteger("0");
		
		
		/**
		 * Divides the 2^(binarystring) equally to each thread
		 * */
		// Execute the threads
		for (;i.compareTo(numberOfThreads) == -1; i=i.add(new BigInteger("1"))) {
			MultiThreadedTruthTableGenerator mtttg = new MultiThreadedTruthTableGenerator(startAt,endAt,binaryStringSize);
			mtttg.start();
			startAt = startAt.add(partition).add(new BigInteger("1"));
			endAt = endAt.add(partition).add(new BigInteger("1"));
		}

	}

}
