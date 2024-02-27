package design.patterns.calculadora

import com.github.stefanbirkner.systemlambda.SystemLambda
import design.patterns.design.patterns.calculadora.Calculadora
import design.patterns.design.patterns.singleton.MyClass
import design.patterns.design.patterns.singleton.Singleton
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class CalculadoraTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `testing a class with only one instance`() {
        val output = SystemLambda.tapSystemOut {
            val calc = Calculadora()
            println(calc.sumar(2, 3))
            println(calc.sumar(3, -2))
            println(calc.multiplicar(2,1))
            println(calc.dividir(9,3))
        }

        assertEquals("5\r\n" +
                "1\r\n" +
                "2\r\n" +
                "3\r\n",output)
    }
}