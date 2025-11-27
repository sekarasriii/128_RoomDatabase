package com.example.meet7_roomdatabase.room

import androidx.room.Database

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase() {
    abstract fun siswaDao(): SiswaDao

}
class DatabaseSiswa {
}