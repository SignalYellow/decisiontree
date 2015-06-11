package decisiontree;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		float ans = Main.calculateSubEntropy(4, 2);
		//System.out.println(ans);
		assertEquals(1.0f,ans,0.001);
	}
	
	@Test
	public void test2(){
		float ans = Main.calculateSubEntropy(3, 0);
		assertEquals(0,ans,0.001);
	}
	
	@Test
	public void test3(){
		float ans = Main.calculateSubEntropy(5, 5);
		assertEquals(0,ans,0.001);
	}
	
	@Test
	public void testCalculateSubEntoryString(){
		float ans = Main.calculateEntropy("5 1 5 2 2 0");
		System.out.println(ans);
		assertEquals(0.705, ans,0.01);
	}

}
