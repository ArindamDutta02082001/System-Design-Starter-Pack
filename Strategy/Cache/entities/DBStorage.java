package Strategy.Cache.entities;

import java.util.HashMap;
import java.util.Map;

/*
   This represents permanent storage (database, file, etc.)
*/
public class DBStorage<K,V> {
    public Map<K,V> database = new HashMap<>();

    public V read(K key) {
        return database.get(key);
    }

    public void write(K key, V val) {
        database.put(key, val);
    }

    public void remove(K key)
    {
        database.remove(key);
    }
}
