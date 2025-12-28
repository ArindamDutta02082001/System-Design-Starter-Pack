package ObserverPattern.PubSub.entities;

public class Subscriber implements Runnable{


    public Topic topic;        // to store which topic this is subscribed to
    public String name;

    public int offset=0;

    public Subscriber( String name , Topic topic)
    {
        this.name = name;
        this.topic = topic;
    }

    // update fn

    @Override
    public synchronized void run() {

        // polling logic inside Subscriber thread run()

        while( true )
        {
            if( offset > topic.getOffset(this) )
            {
                try {
                    wait();
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                    Thread.currentThread().interrupt();
//                    return;
                }
            }

            // poll mar ek mssg le

            // we can use observer to send notification based on channel here printing
            MessageDto mssg = topic.poll(this );
            if(mssg != null)
            {
                System.out.println("[INCOMING] - "+this.name+" - topic - "+topic.TOPICENUM+" - mssg : "+mssg.messageString);
                this.offset++;
            }

        }


    }


    // another easy impleemntation via schedulaed service
    public void run2() {

            // poll mar ek mssg le

            // we can use observer to send notification based on channel here printing
            MessageDto mssg = topic.poll(this );
            if(mssg != null)
            {
                System.out.println("[INCOMING] - "+this.name+" - topic - "+topic.TOPICENUM+" - mssg : "+mssg.messageString);
                this.offset++;
            }

    }
}
