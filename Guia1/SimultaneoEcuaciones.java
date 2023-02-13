public class SimultaneoEcuaciones{
	public static void main(String[] args){
		float x1 = 2, y1 = 4, c1 = -2;
		float x2 = -3, y2 = 5, c2 = 10;
		
		float x = (c1*y2-c2*y1)/(x1*y2-x2*y1);
		float y = (x1*c2-x2*c1)/(x1*y2-x2*y1);
		
		System.out.println("x = " + x + "\n");
		System.out.println("y = " + y);
		
	
	}
}