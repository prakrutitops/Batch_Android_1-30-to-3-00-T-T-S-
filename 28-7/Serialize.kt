import java.io.FileOutputStream
import java.io.ObjectOutputStream

class Serialize
{
    fun a1()
    {
        var s1=Student(101,"a1")
        var f1=FileOutputStream("E://xyz.txt")
        var o1=ObjectOutputStream(f1)
        o1.writeObject(s1)
        println("success")
    }
}