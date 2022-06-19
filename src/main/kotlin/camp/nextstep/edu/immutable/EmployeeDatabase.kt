package camp.nextstep.edu.immutable

object EmployeeDatabase {
    fun loadEmployees(): List<Employee> = listOf(
        createEmployee(name = "김태현", salary = Int.MAX_VALUE),
        createEmployee(name = "김수현", salary = 1_000),
        createEmployee(name = "제이슨", salary = 100_000_000),
    )

    private fun createEmployee(name: String, salary: Int): Employee {
        return Employee().apply {
            this.name = name
            this.salary = salary
        }
    }
}
