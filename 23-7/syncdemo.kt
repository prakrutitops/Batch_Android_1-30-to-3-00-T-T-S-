class Sender
{
    fun send(msg:String)
    {

        println("sending"+msg)

            Thread.sleep(1000)

        println(msg+"sent")


    }
}

class ThreadSend(var msg:String,var sender: Sender) :Thread()
{

    override fun run()
    {
        synchronized(sender)
        {
            sender.send(msg)
        }
        super.run()
    }

}
