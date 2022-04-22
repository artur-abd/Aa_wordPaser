/**
 * Parses an argument with a given parameter.
 * @param args argument list.
 * @param parameter parameter we want to find.
 * @return value going next to parameter or null if does not exists.
 */
fun parseArgument(args: Array<String>, parameter: String): String? {
    val pos = args.indexOf(parameter)
    return if (pos >= 0) {
        args.getOrNull(pos + 1)
    } else {
        null
    }
}

fun decipherMessage(encryptedMessage: String): String =
    StringBuilder().apply {
        encryptedMessage.split(" ").forEach {
            append(getSymbol(it))
        }
    }.toString()

fun getSymbol(encryptedSymbol: String): Char {
    var result = 0
    var power = 1
    encryptedSymbol.forEach {
        if (it == 'A') result += power
        power *= 2
    }
    return Char(result)
}

fun encryptMessage(message: String) =
    StringBuilder().apply {
        message.forEach {
            append(encryptSymbol(it))
            if (it != message.last()) append(" ")
        }
    }.toString()


fun encryptSymbol(symbol: Char): String {
    val code = Integer.toBinaryString(symbol.code).toString().reversed()
    return code.map { if (it == '1') 'A' else 'a' }.joinToString(separator = "") { it.toString() }
}

fun main(args: Array<String>) {
    val encryptedMessage = parseArgument(args, "-d")
    val decipherMessage = parseArgument(args, "-e")
    if (encryptedMessage != null) {
        println("your message is:${decipherMessage(encryptedMessage)}")
    }
    if (decipherMessage != null) {
        println("encrypted message is:${encryptMessage(decipherMessage)}")
    }
}