import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    val message = "Hello World!"
    @Test
    fun decipherMessage() {
        assertEquals(decipherMessage(encryptMessage(message)), message)
    }

    val mySymbol = ' '
    @Test
    fun getSymbolCode() {
        assertEquals(getSymbol(encryptSymbol(mySymbol)), mySymbol.code)
    }

    @Test
    fun encryptMessage() {
    }

    @Test
    fun encryptSymbol() {
        val symbol = ' '
        assertEquals(encryptSymbol(symbol), "aaaaaA")
    }
}