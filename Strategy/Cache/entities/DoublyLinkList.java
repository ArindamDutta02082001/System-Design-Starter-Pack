package Strategy.Cache.entities;

public class DoublyLinkList<K,V> {

    public LRUNode<K,V> head;
    public LRUNode<K,V> tail;

    public  DoublyLinkList( )
    {
        this.head = new LRUNode<K,V>(null,null);
        this.tail = new LRUNode<K,V>(null,null);

        head.next = tail;
        tail.prev = head;
    }

    // utility functions

    // remove the node
    public void removeNode( LRUNode<K,V> node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertFront( LRUNode<K,V> node )
    {
        // for curr node
        node.next = head.next;
        node.prev = head;

        //
        head.next.prev = node;

        // for head node
        head.next = node;

    }


}
