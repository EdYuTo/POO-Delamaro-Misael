
public class MegaSena {

	public static void main(String[] args) {
		Random r = new Random(1023);
				
		for (int i = 0; i < 6; i++) {
			int k = r.getIntRand(60) + 1;
			System.out.printf("%d ", k);
		}
		System.out.printf("\n");
	}

}
