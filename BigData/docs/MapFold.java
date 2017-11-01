public class MapFold {
 
	public static int f(int x){
		return (x % 2 == 0) ? 1 : -1;
	}
	
	public static int g(int x, int y){
		return x + y;
	}

	
	public static int isPrime(int n) {
		if (n < 2) return 0;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) return 0;
		}
		return 1;
	}	
	
		
	public static void main(String[] args) {
		int[] a = {13, 11, 12, 16, 0, 21};
		int[] b = new int[a.length];
		int[] c = new int[a.length];
		
		for (int i = 0; i < a.length; i++){
			b[i] = f(a[i]);
		}
		
		int x = 0;
		for (int i = 0; i < a.length; i++){
			x = g(x, b[i]);
			c[i] = x;
		}
		for (int i = 0; i < a.length; i++)
			System.out.print("\t"+ a[i] + " ");
		System.out.println();
		for (int i = 0; i < a.length; i++)
			System.out.print("\t"+ b[i] + " ");
		System.out.println();
		for (int i = 0; i < a.length; i++)
			System.out.print("\t"+ c[i] + " ");
		System.out.println();		
	}
}
