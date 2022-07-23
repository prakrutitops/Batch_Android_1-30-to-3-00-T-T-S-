class A :Thread()
{
    override fun run()
    {
        super.run()
        for(i in 1..10)
        {
            println("Thread A: "+i)
        }
    }
}
class B :Thread()
{
    override fun run()
    {
        super.run()
        for(i in 1..10)
        {
            println("Thread B: "+i)
        }
    }
}
