class listdata
{

    fun display()
    {
        var list=ArrayList<String>()
        list.add("Android")
        list.add("Java")
        list.add("Php")

        var list2=ArrayList<String>()
        list2.add("Android2")
        list2.add("Java2")
        list2.add("Php2")

        list.addAll(list2)
        list.removeAt(1)
        for(i in list)
        {
            println(i)
        }


    }


}