package Hashtable;

import java.util.LinkedList;

public class Hash<K, V> {
	private final int MAX_SIZE = 10;
	LinkedList<Cell<K, V>>[] items;
	
	public Hash(){
		items = (LinkedList<Cell<K,V>>[]) new LinkedList[MAX_SIZE];
	}
	
	public int hashCodeOfKey(K key){
		return key.toString().length() % items.length;
	}
	
	
	public void put(K key, V value){
		int x = hashCodeOfkey(key);
		if(items[x] == null){
			items[x] = new LinkedLst<Cell<K,V>>();
		}
		LinkedList<Cell<K, V>> c: collieded){
			if(c.equivalent(key)){
					collieded.removed(c)
					break;
			}
		}
	}
}
