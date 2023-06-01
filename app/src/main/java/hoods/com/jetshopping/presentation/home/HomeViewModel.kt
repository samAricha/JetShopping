package hoods.com.jetshopping.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import hoods.com.jetshopping.Graph
import hoods.com.jetshopping.data.room.ItemsWithStoreAndList
import hoods.com.jetshopping.repository.Repository
import hoods.com.jetshopping.ui.Category

class HomeViewModel(
    private val repository: Repository = Graph.repository
): ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    private fun getItems(){

    }


}

data class HomeState(
    val items: List<ItemsWithStoreAndList> = emptyList(),
    val category: Category = Category(),
    val itemChecked: Boolean = false

)