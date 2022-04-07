/**
 * Description:
 * Created by small small su
 * Date: 2022/4/7
 * Email: surao@foryou56.com
 */
// todo map  flatmap
// todo map { it == 每一个元素 T String Int Boolean Char} ... 是把每一个元素加入新集合 List<String>
// todo flatMap { it == 每一个元素T 集合1 集合2 集合3 } ... 是把买一个元素（集合）加入新集合  Lit<List<String>>
// TODO: 2022/4/7 fielter 过滤
// TODO: 2022/4/7 zip 合并功能
fun main() {
    val list = listOf("李元霸", "李连杰", "李小龙")
    // TTT 新的集合 (RRR)
    //原理，把匿名函数最后一行 的返回值 加入一个新的集合，集合的范型是R，并且返回新的集合
    val list2 = list.map {
        "[$it]"
        88
    }
    println(list2)
    //和Rxjava一模一样
    val list3 = list.map {
        "姓名是:$it"
    }.map {
        "$it，文字的长度是:${it.length}"
    }.map {
        "[$it]"
    }.map {
        println(it)
    }

    val list4: List<String> = listOf("里斯", "王武", "赵六", "初期")
    list4.map {
        "你的姓名是：$it"
    }.map {
        "$it,文字长度是:${it.length}"
    }.flatMap {
        listOf("$it 在学习C++", "$it 在学习Java", "$it 在学习Kotlin")
    }.map {
        println(it)
    }

    val nameList = listOf(
        listOf("李元霸", "李连杰", "李小龙"),
        listOf("刘军", "黄小明", "刘明"),
        listOf("刘俊", "黄家驹", "黄飞鸿")
    )

    nameList.map {
//        it == nameList的元素 ==  listOf("李元霸", "李连杰", "李小龙")
        //进来三次
        println(it)
    }

    nameList.flatMap {
        //进来三次
        println(it)
        listOf("") //必须返回一个集合
    }

    nameList.flatMap {
        it.filter {
            //进来9次
            println("$it flatmap filter")
            true
            //过滤器里面 true 会加入到新的集合，进行组装集合，false的话会过滤掉
        }
    }.map {
        print("$it 最终结果;  ")
    }

    nameList.map {
        it.filter {
            //进来9次
            println("$it map filter")
            true
            //过滤器里面 true 会加入到新的集合，进行组装集合，false的话会过滤掉
        }
    }.map {
        print("$it 最终结果")
    }

    // list<T>返回给 map 后的效果 [李元霸, 李连杰, 李小龙] [刘军, 黄小明, 刘明] [刘俊, 黄家驹, 黄飞鸿]
    // list<T>返回给 flatMap 后的效果：李元霸 ;  李连杰 ;  李小龙 ;  刘军 ;  黄小明 ;  刘明 ;  刘俊 ;  黄家驹 ;  黄飞鸿 ;

    println("-------------------------------------------------------------------")
    nameList.flatMap {
        it.filter {
            it.contains('黄')
            //过滤器里面 true 会加入到新的集合，进行组装集合，false的话会过滤掉
        }
    }.map {
        print("$it ")
    }
    println()
    println("----------------------------- ZIP --------------------------------------")

    val names = listOf("张三", "里斯", "王武")
    val ages = listOf(20, 21, 22)
    //RxJava中 zip 合并
    // 把第一个集合 和 第二个集合 合并起来，创建新的集合
    // 创建的新集合 （元素，元素，元素）元素Pair(K,V) K代替第一个集合的元素 V代替第二个结合的元素
    val zip: List<Pair<String, Int>> = names.zip(ages)
    println(zip)
    println(zip.toMap())
    println(zip.toSet())

    zip.forEach {
        println("姓名：${it.first},年龄：${it.second}")
    }

    //    解构的方式
    zip.toMap().forEach { (k, v) ->
        println("姓名：${k},年龄：${v}")
    }




}