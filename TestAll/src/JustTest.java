
public class JustTest {



static void print(int n)
{
	if (n > 1) {
		System.out.println("Hello");
		print(n - 1);
		System.out.println("Hello");
	}
	else{
		System.out.println("Hello");
		}
	}

public static void main(String[] args) {
	print(5);
	
}


}