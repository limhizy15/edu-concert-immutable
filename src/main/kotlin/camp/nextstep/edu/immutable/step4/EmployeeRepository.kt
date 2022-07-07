package camp.nextstep.edu.immutable.step4

class EmployeeRepository {
    private val employees: MutableMap<String, Employee> = mutableMapOf()

    fun save(employee: Employee) {
        employees[employee.name] = employee
    }

    fun findEmployee(name: String): Employee? {
        return employees[name]
    }
}
