package camp.nextstep.edu.immutable.step4

class EmployeeRepository {
    private val employees: MutableMap<EmployeeName, Employee> = mutableMapOf()

    fun save(employee: Employee) {
        employees[employee.name] = employee
    }

    fun findEmployee(name: EmployeeName): Employee? {
        return employees[name]
    }
}
