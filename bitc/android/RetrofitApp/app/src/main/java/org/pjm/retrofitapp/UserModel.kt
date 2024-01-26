package org.pjm.retrofitapp

data class UserModel(
    var id: Long,
    var username: String,
    var password: String,
    var roles: String
)
