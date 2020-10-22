package PrimNum.PrimeNumbers;

import java.util.ArrayList;

public class findPrimeNumbers {

	public ArrayList<String> calcPrime(Object startNum, Object endNum) {

		ArrayList<String> arr = new ArrayList<String>();
		int start = 0;
		int end = 0;
		boolean inputFlag=true;
		
		if(!(startNum instanceof Integer) || !(endNum instanceof Integer)) {   //Input validation - reject other than Integer
			arr.add("Not an Integer");
			inputFlag=false;
		} else {
			start = ((Integer) startNum).intValue();
			end = ((Integer) endNum).intValue();
		}
		
		if (inputFlag == true) {
			if ((start < 1) || (end < 1)){
				arr.add("Number less than 1");
				inputFlag=false;
			}else if(start <= end) {  
				int count;
				for(int i = start; i <= end; i++) {
					count=0;
					for(int j = 1; j <= i; j++) {
						if (i % j == 0)
							count=count+1;
					}
					if (count == 2)
						arr.add(String.valueOf(i));
				}
				if (arr.isEmpty()) {
					arr.add("No Prime num found");
				}
			} else if(start > end) {
				arr.add("First num less than Second num");
			}	
		}
		return arr;
		
	}
	

//	public static void main(String[] args){
//		findPrimeNumbers fp = new findPrimeNumbers();
//		System.out.println(fp.calcPrime(12, 23));
//		System.out.println(fp.calcPrime(12.25, 23.43));
//		System.out.println(fp.calcPrime(0.05, 100));
//		System.out.println(fp.calcPrime("10", 23));
//		System.out.println(fp.calcPrime(13, "23"));
//		System.out.println(fp.calcPrime(-3, 9000));
//
//	}

}
