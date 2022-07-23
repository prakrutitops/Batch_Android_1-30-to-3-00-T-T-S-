class A1 :Runnable
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread A: "+i)
        }
    }

}
class B1 :Runnable
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread B: "+i)
        }
    }

}