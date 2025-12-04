package com.example.meet7_roomdatabase.room
import androidx.room.Dao
import androidx.room.Delete
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

    //edit : tambah 3 fungsi
    @Query("SELECT * from tblSiswa WHERE id = :id")
    fun getSiswa(id: Int): Flow<Siswa>

}