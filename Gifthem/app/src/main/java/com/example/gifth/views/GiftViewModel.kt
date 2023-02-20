package com.example.gifth.views

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.gifth.model.Gift

class GiftViewModel: ViewModel() {
    private val db = Firebase.firestore
    private val giftsCollection = db.collection("gifts")
    val gifts = mutableStateListOf<Gift>()

    fun addG(gift:Gift){
        giftsCollection.document(gift.id).set(gift)
    }

    fun getGifts(){
        giftsCollection.get().addOnSuccessListener{ result ->
            gifts.clear()
            for(document in result){
                val gift = document.toObject<Gift>()
                gifts.add(gift)
            }
        }
    }
}