package mortgage_calculator

object Log {

    private const val SEPARATOR = "======================================================================"
    @JvmStatic fun print(data: Any) {
        println(data)
    }

    @JvmStatic fun separator() {
        println("\n$SEPARATOR\n")
    }

}