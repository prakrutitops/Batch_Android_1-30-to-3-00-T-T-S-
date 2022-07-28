data class User(var name : String, var id : Int)
{

}
class dataclassex
{
    var u1=User("a",101)
    var u2=User("b",102)
    var u3=User("a",101)

    fun display()
    {
        println(u1)
        println(u2.toString())

        if(u1==u3)
        {
            println("Equal")
        }
        else
        {
            println("Not Equal")
        }
        var u4 = u1.copy()
        println(u4)
    }


}
