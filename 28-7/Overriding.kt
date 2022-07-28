open class Overriding
{
    open fun rate():Int
    {
        return 0
    }


}

class Sbi : Overriding()
{
    override fun rate():Int
    {
        return 7
    }
}
class Icici : Overriding()
{
    override fun rate():Int
    {
        return 8
    }
}
class Axis : Overriding()
{
    override fun rate():Int
    {
        return 9
    }
}