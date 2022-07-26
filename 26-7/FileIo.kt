import java.io.FileInputStream
import java.io.FileOutputStream

class FileIo
{

    //fileoutputstream-write
    //fileinputstream-read
    fun enterdata()
    {
        println("Enter 1 for write data")
        println("Enter 2 for read data")
        var n1= readLine()!!.toInt()

        when(n1)
        {
            1->
            {

                var f =FileOutputStream("E://xyz.txt")
                println("Enter your name")
                var s= readLine()
                f.write(s!!.toByteArray())

            }
            2->
            {
                var f=FileInputStream("E://xyz.txt")
                var barr: ByteArray = ByteArray(f.available())
                f.read(barr)
                var str: String = String(barr)
                println(str)


            }




        }
        println("success")
    }





}