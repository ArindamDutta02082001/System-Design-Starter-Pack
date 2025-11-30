package Strategy.Cache.entities;

public class LFUNode<K,V> {

    public K key ;
    public V val;

    public Integer freq;

    public LFUNode<K,V> prev;
    public LFUNode<K,V> next;

    public LFUNode(K key , V val , Integer freq)
    {
        this.key = key;
        this.val = val;
        this.freq = freq;

        this.prev = null;
        this.next = null;
    }
}
