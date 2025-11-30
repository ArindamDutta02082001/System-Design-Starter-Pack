package Strategy.Cache.strategy.eviction;

import Strategy.Cache.entities.DoublyLinkList;
import Strategy.Cache.entities.LRUNode;

import java.util.*;

public class LRUEviction<K,V> implements EvictionStrategy<K,V>{

//    public int capacity;   unlike leetcode here we will not have the size instead in cacheManager

    DoublyLinkList<K,V> dll;

    Map<K, LRUNode<K,V>> mp;

    public LRUEviction( )
    {
//        this.capacity = size;
        dll = new DoublyLinkList<>();
        mp = new HashMap<>();
    }

    // utility functions are already defined in the DLL class

    @Override
    public void put(K key, V val) {

        // if already exists then remove the node
        if(mp.containsKey(key))
        {
            dll.removeNode(mp.get(key));
            mp.remove(key);
        }

        // create a new node and then enter in the DLL and the mp
        LRUNode<K,V> newNode = new LRUNode<>(key,val);
        mp.put(key,newNode);
        dll.insertFront(newNode);

        // Here we are not doing the eviction
        // instead evict has to be called manually , so creating another function
    }

    @Override
    public V get(K key) {

        if(!mp.containsKey(key)) return null;

        // if there then remove and add to front

        LRUNode<K,V> temp = mp.get(key);
        dll.removeNode(temp);
        dll.insertFront(temp);

        return temp.val;
    }

    @Override
    public K evict() {


        // check i mp.size() > capacity     // here we are not dealing with the
//        if(mp.size() > capacity)
//        {
            LRUNode<K,V> temp = dll.tail.prev;
            mp.remove(temp.key);
            dll.removeNode(temp);
            return temp.key;

//        }
    }


}
