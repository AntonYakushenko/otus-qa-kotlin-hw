fun main() {
    MyTestRunner().runTest(Steps(), ::testFun)
}

interface TestRunner <T> {
    fun runTest(steps: T, test: () -> Unit) }

class MyTestRunner : TestRunner <Any> {
    override fun runTest(steps: Any, test: () -> Unit) {
        Steps().before()
        test()
        Steps().after()
    }
}

class Steps{
    fun before(){
        println("before test")
    }

    fun after(){
        println("after test")
    }
}

fun testFun() {
    println("testing")
}



