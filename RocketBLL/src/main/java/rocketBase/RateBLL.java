package rocketBase;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws IOException 
	{
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		double rate = 0;
		if (GivenCreditScore < 600) {
			throw new IOException();
		}else if (GivenCreditScore > 850) {
			throw new IOException();
		}
		for (RateDomainModel n : rates) {
			if (n.getiMinCreditScore() <= GivenCreditScore) {
				rate = n.getdInterestRate();
				return rate;
				
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
				}
			return rate;
		}
		return rate;
		
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{	
		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
