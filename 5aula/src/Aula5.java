
public class Aula5 {

	public static void main(String[] args) throws Exception {
		System.out.println("Digite algo");
		String s = EntradaTeclado.leString();
		s = s.toUpperCase();
				
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		char c;
		
		for (int j = 0; j < s.length(); j++) {
			c = s.charAt(j);
			if (c == 'A') a++;
			else if (c == 'E') e++;
			else if (c =='I') i++;
			else if (c =='O') o++;
			else if (c == 'U') u++;
		}
		System.out.printf("a = [%d]\ne = [%d]\ni = [%d]\no = [%d]\nu = [%d]\n", a, e, i, o, u);
		System.out.printf("%s\n", s);
		
		System.out.println("Digite algo novamente");
		String t = EntradaTeclado.leString();
		t = t.toUpperCase();
		
		if (s.startsWith(t)) 
			System.out.printf("A 1 String comeca com a 2\n");
		else if (s.endsWith(t))
			System.out.printf("A 1 String acaba com a 2\n");
		else
			System.out.printf("A 1 String nao comeca nem termina com a 2\n");
	}
	
}
