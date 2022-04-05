/**
 * Description:
 * Created by small small su
 * Date: 2022/4/5
 * Email: surao@foryou56.com
 */
/*
* todo apply
*      1. 返回info本身 :谁
*      2. 匿名函数里面持有的是this == str本身：this
* todo let
*      1. let函数返回类型 是根据最后一行变化而变化：最后
*      2. let函数 里面持有的是 it== 集合本身：it
*
* todo run
*      1. run函数返回类型 是根据最后一行变化而变化 ：最后
*      2. 匿名函数里面持有的是this == str本身： this
*
*  todo with 和run 一模一样只有使用不同，单无str.with，必须传给他 with（str）
*      1. with函数返回类型 是根据最后一行变化而变化 ：最后
*      2. 匿名函数里面持有的是this == str本身：this
*
*  todo also内置函数 str.also
*      1.also 用于str本身 用于str本身，谁.also 就返回谁，不变：谁
*      2.持有it == str本身：it
*
*  todo takeIf 内置函数
*      1.如果 true，返回name本身，false 返回null
*      2.it
*
*  todo takeUnless 和 takeIf 功能相反
*      1.如果 true，返回null，false 返回name本身
*      2.it
*      注：为什么有 takeUnless ？一个takeIf不久够了么
*/


fun main() {

    //目标 万能类型 任何类型都可以使用我的mLet,扩展内置范型函数
    "Derry".mLet {
        it
        true
        "OK"
    }
    'C'.mLet {
        it
    }
    123.mLet {
        it
    }
}

//private 私有化
//inline  我们的函数是高阶函数，所以用到内联,使用lambda优化，性能提高
// fun<I,O> 函数中两个范型 ，I 是输入 ，
// I.mLet 对I输入进行函数扩展，扩展函数名称是mLet，意味着所有类型，都可以用 xxx.mLet
// lambda:(I 输入) ->O  输出
// :O 会根据用户的返回类型 变化而变化
// lambda(this) I 进行函数扩展，在整个扩展函数里面，this == I本身
private inline fun <I, O> I.mLet(lambda: (I) -> O): O = lambda(this)

/**
 * todo ----------------------------- P118
 *  1. apply，also 返回类型是一样的，永远返回info本身。最后一行无法作为返回值，不影响函数
 *      info.apply{     this == info 本身     }
 *      info.also{      it == info 本身       }
 *      应用点：链式调用：File("xx").apply{   setFileXXX()    }.apply{ ... }.apply{ ... }
 *                     File("xx").also{  it.setFileXXX()  }.apply{ ... }.apply{ ... }
 *  2. let, run, with  由用户决定返回类型，会根据匿名函数最后一行的返回，来决定返回的情况
 *      info.run{    this == info 本身    }
 *      info.let{    it == info 本身       }
 *      应用点： info.run{    lenth      }
 *              info.let{    it.lenth   }
 *      with : 用法同 run但是  with(info){     持有this       }
 *
 */

// TODO: 2022/4/5 apply 的源码学习












