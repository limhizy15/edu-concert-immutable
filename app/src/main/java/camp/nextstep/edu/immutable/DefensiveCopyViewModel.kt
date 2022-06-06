package camp.nextstep.edu.immutable

import androidx.lifecycle.ViewModel


class DefensiveCopyViewModel : ViewModel() {

    private val _users: MutableList<User> = mutableListOf()
    val users: List<User>
        get() = _users

    fun fetchUsers() {
        _users.add(User(name = "홍길동", age = 10))
        _users.add(User(name = "김길동", age = 11))
    }
}
