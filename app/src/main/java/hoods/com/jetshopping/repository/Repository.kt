package hoods.com.jetshopping.repository

import hoods.com.jetshopping.data.room.ItemDao
import hoods.com.jetshopping.data.room.ListDao
import hoods.com.jetshopping.data.room.StoreDao
import hoods.com.jetshopping.data.room.models.Item
import hoods.com.jetshopping.data.room.models.ShoppingList
import hoods.com.jetshopping.data.room.models.Store

//Repository is for connecting between data layer and UI layer
class Repository(

    private val listDao: ListDao,
    private val itemDao: ItemDao,
    private val storeDao: StoreDao
    
) {

    //the following are methods which are going to help us get our data.

    val store = storeDao.getAllStores()
    val getItemsWithStoreAndList = listDao.getItemsWithStoreAndList()


    //getting our data while filtering it

    fun getItemWithStoreAndList(id: Int) = listDao
        .getItemWithStoreAndListFilteredById(id)

    fun getItemWithStoreAndListFilteredById(id: Int) =
        listDao.getItemsWithStoreAndListFilteredById(id)

    //the following are functions that are going to help us insert/save our data

    suspend fun insertList(shoppingList: ShoppingList){
        listDao.insertShoppingList(shoppingList)
    }
    suspend fun insertStore(store: Store){

        storeDao.insert(store)

    }

    suspend fun insertItem(item: Item){

        itemDao.insert(item)

    }

    suspend fun updateItem(item: Item){

        itemDao.update(item)

    }

    //the following are functions that are going to help us delete/erase data

    suspend fun deleteItem(item: Item){

        itemDao.delete(item)

    }


}