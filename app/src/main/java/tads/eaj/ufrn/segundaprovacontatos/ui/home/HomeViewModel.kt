package tads.eaj.ufrn.segundaprovacontatos.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import tads.eaj.ufrn.segundaprovacontatos.repository.ContactRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private var repository: ContactRepository) : ViewModel() {

    var contacts = repository.listAll().asLiveData()
}