import java.util.ArrayList;
import java.util.List;
/**
 * @author khan_at
 *
 */

public class HashTable<K, V> {
	private int capacity = 7;
	private float loadFactor = 0;
	private int load = 0;
	
	Object[] table;	
	
	public HashTable(){
		init();
	}
	
	private void init(){
		int i = 0;
		table = new Object[capacity];	
		while(i < capacity){
			table[i] =  new ArrayList<ListNode<K, V>>();
			++i;
		}		
	}
	
	public void add(K key, V value){
		int index = getIndex(key);
		List<ListNode<K, V>>list = (List<ListNode<K, V>>) table[index];
		int i = 1; 
		System.out.print("key: " + key.toString() + " : hash: " + index  );
		while(list.size() != 0){
			int j = this.doubleHashing(index, key, i);
			list = (List<ListNode<K, V>>) table[j];
			System.out.println(" : newHash: " + j + " : i: " + i);
			i++;
		}
		if(i == 1)
			System.out.println("");
		list.add(new ListNode(key, value));
	
		load++;
		loadFactor = (new Float(load) / new Float(capacity)) * 100;
		
		if(loadFactor > 75){
			resize();
		}	
	}
	
	public V getValue(K key){
		int index = getIndex(key);
		
		int i = 1; 

		List<ListNode<K, V>> list = (List<ListNode<K, V>>) table[index];
		if(list.size() == 0)
			return null;

		while(list.size() != 0){
			for(ListNode<K, V> l : list){
				if(l.getKey().equals(key))
					return l.getValue();
			}
			list = (List<ListNode<K, V>>) table[this.doubleHashing(index, key, i)];
			i++;
		}
		
		return null;
	}	
	
	private void resize(){
		System.out.println("Doubling in size...");
		int oldCapacity = capacity;
		load = 0;
		capacity = capacity * 2 + 1;
		Object[] tmp = table;
		init();
   	
		int i = 0;
		while(i < oldCapacity){
			List<ListNode<K, V>> list = (List<ListNode<K, V>>) tmp[i];
			for(ListNode<K, V> l : list){
				add(l.getKey(), l.getValue());
			}	
			++i;
		}
	}
	
	
	private int getIndex(K key){
		// double hashing
//		int hash = key.hashCode() * 73;
//		return Math.abs((hash >> 2) % capacity);
		return 1;
	}
	
	private int doubleHashing(int hash, K key, int i){
		return Math.abs(((i * (73 - (key.hashCode()) % 73)) + hash) % capacity);
	}
}
