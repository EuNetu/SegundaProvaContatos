package tads.eaj.ufrn.segundaprovacontatos.ui.detalhes

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tads.eaj.ufrn.segundaprovacontatos.model.Contact
import tads.eaj.ufrn.segundaprovacontatos.repository.ContactRepository
import tads.eaj.ufrn.segundaprovacontatos.ui.home.adapters.ContactAdapter
import javax.inject.Inject

@HiltViewModel
class AlteraViewModel @Inject constructor(private var repository: ContactRepository) : ViewModel() {
    var contact: Contact? = null

    fun contatoSelecionado(id: Long) {
        Log.i("idContact", id.toString())
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                id.let {
                    contact = repository.findById(it)
                }
            }
        }
    }

    fun alteraButtonEvent() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                contact?.let { repository.update(it) }
            }
        }
    }
}