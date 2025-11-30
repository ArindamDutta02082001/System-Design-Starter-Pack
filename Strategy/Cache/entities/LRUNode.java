package Strategy.Cache.entities;

public class LRUNode<K,V> {

    public K key ;
    public V val;

    public LRUNode<K,V> prev;
    public LRUNode<K,V> next;

    public LRUNode( K key , V val )
    {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
