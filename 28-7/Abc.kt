interface  Print
{
    fun print()
}
interface  Show
{
    fun show()
}
class Abc :Print,Show
{
    override fun print()
    {
        println("print accessed")
    }

    override fun show()
    {
        println("show accessed")
    }

}