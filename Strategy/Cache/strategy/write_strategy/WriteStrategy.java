package Strategy.Cache.strategy.write_strategy;

import Strategy.Cache.entities.CacheStorage;
import Strategy.Cache.entities.DBStorage;

public interface WriteStrategy<K,V>{

    // write()
    public void write(K key , V val , CacheStorage<K,V> cacheStorage , DBStorage<K,V> dbStorage);

}
