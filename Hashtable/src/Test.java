
public class Test {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		HashTable<String, String> ht = new HashTable<>();
		ht.add("hello", "world");
		ht.add("brown", "fox");
		ht.add("design", "patterns");

		// map to same index
		ht.add("F", "x world");
		ht.add("P", "a patterns");			

		
		// resize 
		ht.add("jib", "jab");
		ht.add("tic", "tac");		
		ht.add("red", "black");			
		System.out.println(ht.getValue("F")); 
		System.out.println(ht.getValue("P")); 	}

}
