package Strategy.Cache.strategy.eviction;

public interface EvictionStrategy<K,V> {

    // get , put , remove

    public void put(K key , V val);
    public V get(K key);

    public K evict();
}
