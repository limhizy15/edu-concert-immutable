package camp.nextstep.edu.immutable

class DefensiveCopyViewModel {

    private val _employees: MutableList<Employee> = mutableListOf()
    val employees: List<Employee>
        get() = _employees

    fun fetchUsers() {
        _employees.add(Employee(name = "홍길동", age = 10))
        _employees.add(Employee(name = "김길동", age = 11))
    }
}
