package org.pjm.firebaseapp

import androidx.multidex.MultiDexApplication
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MyApplication : MultiDexApplication() {
    companion object {
        lateinit var auth: FirebaseAuth
        var email: String? = null
        fun checkAuth(): Boolean {
            var currentUser = auth.currentUser // 현재 로그인 한 유저
            return currentUser?.let {
                email = currentUser.email // 현재 로그인 한 유저의 이메일 정보
                currentUser.isEmailVerified // 이메일 조회
            }?: let {
                false
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        auth = Firebase.auth
    }

}