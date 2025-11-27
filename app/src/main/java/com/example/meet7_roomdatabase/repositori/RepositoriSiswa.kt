package com.example.meet7_roomdatabase.repositori
import kotlinx.coroutines.flow.Flow
import com.example.meet7_roomdatabase.room.Siswa

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}
