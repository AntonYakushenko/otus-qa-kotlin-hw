import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions


/*Создайте класс реализующий интерфейс
Внутри класса переопределите метод runTest
Внутри этого метода необходимо сначала вызвать методы с before* из steps, далее прогнать тест (запустить передаваемую функцию test), и после вызвать методы с after* из steps.
Вызовы before* и after* нужно обернуть в лог/печать в консоль.
Проверьте работоспобоность написанного кода (можно в методе main).*/

fun main() {
   //val KClass<*>.declaredFunctions: Collection<KFunction<*>>
    val steps = Steps::class.declaredFunctions.filter { it.name.startsWith("before")}
    println(steps)
    MyTestRunner().runTest(Steps(), ::testFun)

}
interface TestRunner <T> {
    fun runTest(steps: Any, test: () -> Unit) }

class MyTestRunner : TestRunner <Any> {

    override fun runTest(steps: Any, test: () -> Unit) {
        Steps().beforeTest()
        test()
        Steps().afterTest()
    }
}

class Steps {

   fun beforeTest() {
    println("before test")
    }

    fun afterTest() {
       println("after test")

    }
}
fun testFun() {
    println("testing")
}



