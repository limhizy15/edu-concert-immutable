package camp.nextstep.edu.immutable.step4

@JvmInline
value class EmployeeName(val value: String) {
    init {
        require(value.isNotBlank())
        require(value.length > MIN_LENGTH)
    }

    companion object {
        private const val MIN_LENGTH = 2
    }
}
