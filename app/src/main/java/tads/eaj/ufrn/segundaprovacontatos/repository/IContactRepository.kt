package tads.eaj.ufrn.segundaprovacontatos.repository

import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.segundaprovacontatos.model.Contact

interface IContactRepository {
    fun listAll(): Flow<List<Contact>>
    fun create(c:Contact)
    fun findById(id:Long):Contact?
    fun update(c:Contact)
}