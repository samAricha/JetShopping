package hoods.com.jetshopping

import android.content.Context
import hoods.com.jetshopping.data.room.ShoppingListDatabase
import hoods.com.jetshopping.repository.Repository

//this class is going to act as the dependency injector for our application
object Graph {

    lateinit var db: ShoppingListDatabase
    private set

    val repository by lazy {
        Repository(
            listDao = db.listDao(),
            itemDao = db.itemDao(),
            storeDao = db.storeDao()
        )
    }

    fun provideDb(context: Context){
        ShoppingListDatabase.getDatabase(context)
    }
}