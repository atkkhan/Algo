package Hashtable;

public class Cell<K, V> {
	private K key;
	private V value;
	
	public Cell(K k, V v){
		key = k;
		value = v;
	}
	
	public boolean equiavalent(Cell<K, V> c){
		return equivalent(c.getKey());
	}
	
	public boolean equivalent(K k){
		return key.equals(k);
	}
	
	public K getKey(){return key;}
	public V getValue(){return value;}
}
