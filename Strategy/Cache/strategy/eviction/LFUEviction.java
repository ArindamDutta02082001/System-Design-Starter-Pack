package Strategy.Cache.strategy.eviction;

import Strategy.Cache.entities.LFUNode;
import Strategy.Cache.entities.LRUNode;

import java.util.*;

public class LFUEviction<K,V> implements EvictionStrategy<K,V>{

    // creating 2 HashMap

    Map<K, LFUNode<K,V>> nodeMap = new HashMap<>();  // for key - Node
    Map<Integer , Set<LFUNode<K,V>>> freqMap = new HashMap<>();

    Integer minFreq;

    public LFUEviction( int minFreq )
    {
        this.minFreq = minFreq;
    }

    @Override
    public void put(K key, V val) {

        // if already exists then update the value and freq
        if( nodeMap.containsKey(key) )
        {
            LFUNode<K,V> node = nodeMap.get(key);
            node.val = val;
            updateFreq(node);
            return;
        }

        // else create a new node with freq 1
        LFUNode<K,V> newNode = new LFUNode<>(key,val,1);

        // adding to the nodeMap
        nodeMap.put(key,newNode);

        // adding to the freqMap
        if( !freqMap.containsKey(1) )
        {
            Set<LFUNode<K,V>> temp = new HashSet<>();
            temp.add(newNode);
            freqMap.put(1,temp);
        }
        else
            freqMap.get(1).add(newNode);

        // updating the minFreq to 1
        minFreq = 1;

    }

    @Override
    public V get(K key) {
        if(!nodeMap.containsKey(key)) return null;

        LFUNode<K,V> node = nodeMap.get(key);
        updateFreq(node);
        return node.val;

    }

    @Override
    public K evict() {
        // getting the least frequently used nodes
        Set<LFUNode<K,V>> leastFreqSet = freqMap.get(minFreq);

        // getting the first node to evict
        LFUNode<K,V> nodeToEvict = leastFreqSet.iterator().next();

        // removing it from the nodeMap and freqMap
        nodeMap.remove( nodeToEvict.key );
        leastFreqSet.remove( nodeToEvict );

        // returning the key
        return nodeToEvict.key;
    }


    // utility fn to update the freq

    public void updateFreq( LFUNode<K,V> node )
    {
        // getting the old freq
        Integer oldFreq = node.freq;
        Set<LFUNode<K,V>> freqSet = freqMap.get(oldFreq);

        // updating the node freq
        node.freq++;

        // removing the old entry from the freq set and
        freqSet.remove(node);

        // updating the new freq , and adding the node to it
        if( !freqMap.containsKey(node.freq) )
        {
            //
            Set<LFUNode<K,V>> temp = new HashSet<>();
            temp.add(node);
            freqMap.put(node.freq, temp);
        }
        else
            freqMap.get(node.freq).add(node);

        // updating the minFreq
        if(oldFreq == minFreq && freqSet.size() == 0)
        {
            minFreq++;
        }
    }



}
