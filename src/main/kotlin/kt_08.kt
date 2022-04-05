import java.io.File

/**
 * Description:
 * Created by small small su
 * Date: 2022/3/31
 * Email: surao@foryou56.com
 */

fun main() {
    // TODO: 2022/4/1 数组
    /**
     * IntArray intArrayOf
     * DoubleArray doubleArrayOf
     * LongArray longArrayOf
     * ShortArray shotArrayOf
     * ByteArray
     * FloatArray
     * BooleanArray
     * Array arrayOf  对象数组
     */

    val intArray: IntArray = intArrayOf(1, 2, 3, 4, 5)
    println(intArray[0])
//    println(intArray[5])//崩溃 越界
    println(intArray.elementAtOrElse(5) {
        -1
    })
    println(intArray.elementAtOrNull(5) ?: "为空了")

    // TODO: 2022/4/1 集合转数组
    val charArray = listOf('A', 'B', 'C').toCharArray()
    charArray.toList()
    charArray.toMutableList()

    // TODO: 2022/4/1 对象类型
    val objArray: Array<File> = arrayOf<File>(File("AAA"), File("BBB"), File("CCC"))

    val objArray2 = arrayOf<File>(File("AAA"), File("BBB"), File("CCC"))

    // TODO: 2022/4/1 Map
    val mMap1: Map<String, Double> = mapOf("derry" to 34.3, "srwing" to 55.6)
    val mMap2 = mapOf(Pair("Derry", 33.3))

    // TODO: 2022/4/1
    val mMap3 = mapOf("Derry" to 123, "Kevin" to 45)
    mMap3.get("Derry")
    mMap3["Derry"] // Map对 [] 进行了 运算符重载
    println(mMap3["xxx"]) //如果找不到返回null，不会崩溃
    println(mMap3.getOrDefault("xxx", 99))
    println(mMap3.getOrElse("xxx") { -1 })

    //不推荐 会崩溃
//    println(mMap3.getValue("xxx"))

    // TODO: 2022/4/1 map的遍历
    val map4: Map<String, Int> = mapOf(Pair("Derry", 123), Pair("String", 345), "Leo" to 567)
    map4.forEach {
        //it == 每一个元素 it == Map.Entry<String , Int>
        println("K:${it.key} ; V:${it.value}")
    }

    map4.forEach { key, value ->
        println("K:${key} ; V:${value}")
    }

    map4.forEach { (k, v) ->
        println("K:${k} ; V:${v}")
    }

    for (item in map4) {
        println("K:${item.key} ; V:${item.value}v}")
    }

    // TODO: 2022/4/2 可变map
    val map5 = mutableMapOf(Pair("Derry", 123), Pair("String", 345), "Leo" to 567)
    map5 += "AAA" to (111)
    map5 -= "Derry"
    map5["CCC"] = 999
    map5.put("DDD", 999)
    val r = map5.getOrPut("FFF") { 555 } //如果集合中没有 FFF ，则先把 "FFF" 加到集合中，再从集合中取出来

    println(r)
    println(map5["FFF"])
    val r2 = map5.getOrPut("Derry") { 666 }  //如果有 备用值就失效了
    println(r2)







}

