fun main(args: Array<String>)
{
   /* var a=A1()
    var b=B1()*/

  /*  var t1=Thread(A1())
    var t2=Thread(B1())

    t1.start()
    t2.start()*/

    var sender:Sender=Sender()

    var t=ThreadSend("Hii",sender)
    var t2=ThreadSend("Byee",sender)

    t.start()
    t2.start()


}