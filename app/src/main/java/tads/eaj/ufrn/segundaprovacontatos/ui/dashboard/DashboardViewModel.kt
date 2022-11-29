package tads.eaj.ufrn.segundaprovacontatos.ui.dashboard


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tads.eaj.ufrn.segundaprovacontatos.model.Contact
import tads.eaj.ufrn.segundaprovacontatos.repository.ContactRepository
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(var repository: ContactRepository) : ViewModel() {

    var contact = MutableLiveData<Contact>()

    init {
        contact.value = Contact("", "", "", "", true, "", "")
    }

    fun cadastrarButtonEvent(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                contact.value?.let { repository.create(it) }
            }
        }
    }
}