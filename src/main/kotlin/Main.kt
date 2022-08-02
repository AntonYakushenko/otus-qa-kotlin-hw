import kotlin.reflect.full.declaredFunctions

fun main() {
    MyTestRunner().runTest(Steps(), ::testFun)
}
interface TestRunner <T> {
    fun runTest(Steps: Any,  test: () -> Unit) }

class MyTestRunner : TestRunner <Any> {

    override fun runTest(obj: Any, test: () -> Unit) {
        steps(obj, "before")
        test()
        steps(obj, "after")
    }
    private fun steps (obj: Any ,prefix : String){
        val steps = Steps::class.declaredFunctions.filter { it.name.startsWith(prefix)}
        steps.forEach { it.call(obj) }
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





