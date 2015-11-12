
public class ListNode<K, V> {
	K key;
	V value;
	
	public ListNode(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey(){ return this.key; }
	public V getValue(){ return this.value; }
}
