package com.example.meet7_roomdatabase.repositori
import kotlinx.coroutines.flow.Flow
import com.example.meet7_roomdatabase.room.Siswa
import com.example.meet7_roomdatabase.room.SiswaDao

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
    //edit 1 : tambah 3 fungsi berikut
    fun getSiswaStream(id: Int): Flow<Siswa?>
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}
