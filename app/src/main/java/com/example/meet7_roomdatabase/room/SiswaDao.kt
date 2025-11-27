package com.example.meet7_roomdatabase.room
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface SiswaDao {
    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
    fun getAllSiswa() : Flow<List<Siswa>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)
}