package camp.nextstep.edu.immutable.step2

data class Employee(var name: String, var salary: Int)

class Employees(val values: List<Employee>)
