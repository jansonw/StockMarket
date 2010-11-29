public class Test {
  public static void main(String args[]) {
    System.out.println("Hello World");
    
    Dice d = new Dice();
    int arr[] = new int[6];
    
    for(int i = 0; i < 10000; i++) {
    
    	int val = d.rollOne();
    	arr[val-1]++;
    	
    	//System.out.println(val);
    
    	Pair p = d.rollTwo();
    	
    	arr[p.getVal1() - 1]++;
    	arr[p.getVal2() - 1]++;
    	
    	//System.out.println(p.getVal1() + "     " + p.getVal2());
    
    	System.out.println("Done");
    }
    
    for(int i = 0; i < 6; i++) {
    	System.out.println(arr[i]);
    }
  }
}
