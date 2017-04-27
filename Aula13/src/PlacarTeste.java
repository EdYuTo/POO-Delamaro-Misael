

import static org.junit.Assert.*;

import org.junit.Test;

public class PlacarTeste {

	@Test (expected=IllegalArgumentException.class)
	public void testAddException1() {
		Placar p1 =  new Placar();
		p1.add(-1, new int[] {1, 1, 1 , 1, 1});
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddException2() {
		Placar p1 =  new Placar();
		p1.add(15, new int[] {1, 1, 1 , 1, 1});
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddException3() {
		Placar p1 =  new Placar();
		p1.add(1, new int[] {1, 1, 1 , 1, 1});
		p1.add(1, new int[] {1, 1, 1 , 1, 1});
	}
	
	@Test
	public void testAdd() {
		Placar p1 =  new Placar();
		p1.add(10, new int[] {1, 1, 1 , 1, 1});
		assertEquals(40, p1.getScore());
	}
	
	@Test
	public void testGetScoreVazio() {
		Placar p1 =  new Placar();
		int k = p1.getScore();
		assertEquals(0, k);
	}

	@Test
	public void testGetScore() {
		Placar p1 =  new Placar();
				
		p1.add(10, new int[] {3, 3, 3, 3, 3});
		p1.add(9, new int[] {3, 3, 3, 3, 1});
		p1.add(8, new int[] {1, 2, 3, 4, 5});
		p1.add(7, new int[] {1, 1, 1, 2, 2});
		p1.add(6, new int[] {6, 6, 6, 6, 6});
		p1.add(5, new int[] {5, 5, 5, 5, 5});
		p1.add(4, new int[] {4, 4, 4, 4, 4});
		p1.add(3, new int[] {3, 3, 3, 3, 3});
		p1.add(2, new int[] {2, 2, 2, 2, 2});
		p1.add(1, new int[] {1, 1, 1, 1, 1});
		
		int k = p1.getScore();
		assertEquals(210, k);
	}
	
	@Test
	public void testToString() {
		Placar p1 = new Placar();
		assertEquals("(1)	|	(7)	|	(4)\n(2)	|	(8)	|	(5)\n(3)	|	(9)	|	(6)\n	|	(10)	|\n", p1.toString());
		
		p1.add(10, new int[] {3, 3, 3, 3, 3});
		p1.add(9, new int[] {3, 3, 3, 3, 1});
		p1.add(8, new int[] {1, 2, 3, 4, 5});
		p1.add(7, new int[] {1, 1, 1, 2, 2});
		p1.add(6, new int[] {6, 6, 6, 6, 6});
		p1.add(5, new int[] {5, 5, 5, 5, 5});
		p1.add(4, new int[] {4, 4, 4, 4, 4});
		p1.add(3, new int[] {3, 3, 3, 3, 3});
		p1.add(2, new int[] {2, 2, 2, 2, 2});
		p1.add(1, new int[] {1, 1, 1, 1, 1});
		
		String esperado = "5	|	15	|	20\n10	|	20	|	25\n15	|	30	|	30\n	|	40	|\n";
		assertEquals(esperado, p1.toString());
	}

}
