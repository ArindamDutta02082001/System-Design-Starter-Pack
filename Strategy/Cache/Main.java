package Strategy.Cache;

import Strategy.Cache.strategy.eviction.EvictionStrategy;
import Strategy.Cache.strategy.eviction.LFUEviction;
import Strategy.Cache.strategy.eviction.LRUEviction;
import Strategy.Cache.strategy.write_strategy.WriteStrategy;
import Strategy.Cache.strategy.write_strategy.WriteThroughStrategy;

public class Main {

    public static void main( String args[] )
    {

        // ******************** setting the actors ***********************


        // LRU cache
        // Eviction strategy
        EvictionStrategy<Integer,Integer> ev = new LRUEviction<>();

        // Write Policy
        WriteStrategy<Integer,Integer> ws = new WriteThroughStrategy<>();

        // actual cache
        // cache 1

        CacheManager<Integer,Integer> cacheManager1 = new CacheManager<>( 2 ,ev , ws);


        // LFU cache
        // Eviction strategy
         EvictionStrategy<Integer,Integer> ev2 = new LFUEviction<>(2);

        // Write Policy
            WriteStrategy<Integer,Integer> ws2 = new WriteThroughStrategy<>();

        // actual cache
        // cache 2
        CacheManager<Integer,Integer> cacheManager2 = new CacheManager<>( 2 ,ev2 , ws2);







        // ******************** actions ***********************


        // for LRU cache
        /*
         store
          1-11
          2-22
          3-33
          4-44
         */

//        cacheManager1.get(1);  // should be null
//        cacheManager1.put(1,11);
//        cacheManager1.put(2,22);
//        cacheManager1.put(3,33);
//        cacheManager1.put(4,44);
//
//        cacheManager1.printCDB();


        // for LFU cache
        /*
         store
          1-11
          2-22
          3-33
          4-44
         */

        cacheManager2.get(1);  // should be null
        cacheManager2.put(1,11);
        cacheManager2.get(1);  // should be 11 , also marking as most frequent

        cacheManager2.put(2,22);
        cacheManager2.put(3,33);
        cacheManager2.put(4,44);

        cacheManager2.printCDB();

    }
}
