package bozo.rand;
import java.util.Calendar;

public class Random {
	//parametros da geracao
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	private long xi = 1023; //semente [public v2], [private v1]

	public double getRand() {
		xi = (a + m * xi) % p;
		double d = xi;
		return d / p;
	}
	
	public int getIntRand(int max) {
		double d = getRand() * max;
		return (int) d;
	}
	
	public void setSemente (int semente) {
		xi = semente;
	}
	
	public Random(int k) {
		xi = k;
	}
	
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis();
	}
 }
/**
*@Override 
*	public String toString() {
*		return xi + "";
*	}
*/