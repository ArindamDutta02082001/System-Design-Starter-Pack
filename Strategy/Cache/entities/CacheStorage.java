package Strategy.Cache.entities;

import java.util.HashMap;
import java.util.*;

public class CacheStorage<K,V> {

    public Map<K,V> cacheDB = new HashMap<>();

    public V read(K key) {
        return cacheDB.get(key);
    }

    public void write(K key, V val) {
        cacheDB.put(key, val);
    }

    public void remove(K key)
    {
        cacheDB.remove(key);
    }

    // utiltiy fn
    public void printCacheDB()
    {
        for( K key : cacheDB.keySet() )
            System.out.println("Key :"+key+" val : "+cacheDB.get(key));
    }
}
