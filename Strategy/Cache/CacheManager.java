package Strategy.Cache;

import Strategy.Cache.entities.CacheStorage;
import Strategy.Cache.entities.DBStorage;
import Strategy.Cache.strategy.eviction.EvictionStrategy;
import Strategy.Cache.strategy.write_strategy.WriteStrategy;

public class CacheManager<K,V> {

    // the manager of the cache , we will aggregate all of them here

    // this is the actual cache -->
    public int capacity;
    public CacheStorage<K, V> cacheStorage;
    public DBStorage<K, V> dbStorage;
    public EvictionStrategy<K, V> evictionStrategy;
    public WriteStrategy<K, V> writeStrategy;

    public CacheManager( int size , EvictionStrategy<K,V> evictionStrategy , WriteStrategy<K,V> writeStrategy)  // only pass the policy
    {
        this.capacity = size;

        this.evictionStrategy = evictionStrategy;
        this.writeStrategy = writeStrategy;

        this.cacheStorage = new CacheStorage<>();
        this.dbStorage = new DBStorage<>();

    }

    // cache manager will use read
    public V get(K key)
    {
        // check in the cache
        V value = cacheStorage.read(key);
        if( value == null )
        {
            System.out.println("key "+key+" dont exist in cache , checking in DB if found !!");

            // EXTRA I am doing not req
            // checking in the DB , if found update in cache
            V val = dbStorage.read(key);
            if(val == null)
            {
                System.out.println("key "+key+" dont exist in DB !!");
                return null;
            }

            System.out.println("key "+key+" found in DB , val : " + val);

            // update the eviction policy and the cacheDB
            cacheStorage.write(key,val);
            evictionStrategy.put(key,val);
        }


        evictionStrategy.get(key);
        return cacheStorage.read(key);

    }


    public void put( K key , V val )
    {



        // here we will use the write policy , then update the eviction policy
        writeStrategy.write(key,val , cacheStorage , dbStorage);
        evictionStrategy.put(key, val);
        System.out.println("key "+key+" & val : " + val+" set success !!");

        // after putting we will check the cacheDB storage (from DbStorage it is not required to remove )
        if(cacheStorage.cacheDB.size() >= capacity )
        {
            K evictKey = evictionStrategy.evict();
            cacheStorage.remove(evictKey);
            System.out.println(" since the cache overflowed , key :"+evictKey+" evicted !!");

        }




    }

    public void printCDB()
    {
        cacheStorage.printCacheDB();
    }
}
