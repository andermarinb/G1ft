package com.example.gifth.views

import androidx.compose.runtime.mutableStateListOf
import com.example.gifth.model.Gift
import com.example.gifth.model.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class UserViewModel {
    private val db = FirebaseFirestore.getInstance()
    private val giftsCollection = db.collection("gifts")
    val users = mutableStateListOf<User>()

    fun addG(user: User){
        giftsCollection.document(user.id).set(user)
    }

    fun getGifts(){
        giftsCollection.get().addOnSuccessListener{ result ->
            users.clear()
            for(document in result){
                val gift = document.toObject<User>()
                users.add(gift)
            }
        }
    }
}