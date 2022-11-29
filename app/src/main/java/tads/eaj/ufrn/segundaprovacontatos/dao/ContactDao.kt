package tads.eaj.ufrn.segundaprovacontatos.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.segundaprovacontatos.model.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun listAll(): Flow<List<Contact>>

    @Query("SELECT * FROM contact where id=:id")
    fun findById(id:Long):Contact?

    @Query("DELETE FROM contact")
    fun deleteAll()

    @Delete
    fun delete(c:Contact)

    @Update
    fun update(c:Contact)

    @Insert
    fun create(c:Contact)

}