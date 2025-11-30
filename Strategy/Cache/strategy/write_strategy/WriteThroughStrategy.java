package Strategy.Cache.strategy.write_strategy;

import Strategy.Cache.entities.CacheStorage;
import Strategy.Cache.entities.DBStorage;

public class WriteThroughStrategy<K,V> implements WriteStrategy<K,V>{
    @Override
    public void write(K key, V val, CacheStorage<K, V> cacheStorage, DBStorage<K, V> dbStorage) {

        // in write through , first write in Cache then to DB  in sync
        cacheStorage.cacheDB.put(key,val);
        dbStorage.write(key,val);

    }
}
