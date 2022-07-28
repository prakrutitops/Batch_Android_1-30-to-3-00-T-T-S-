import java.io.FileInputStream
import java.io.ObjectInputStream

class Deserialize
{
    fun b1()
    {
        var o1=ObjectInputStream(FileInputStream("E://xyz.txt"))
        var s :Student= o1.readObject() as Student
        println("${s.id}  ${s.name}")
    }
}