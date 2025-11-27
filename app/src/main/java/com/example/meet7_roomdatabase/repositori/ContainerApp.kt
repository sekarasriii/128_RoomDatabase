package com.example.meet7_roomdatabase.repositori

import android.content.Context
import com.example.meet7_roomdatabase.room.DatabaseSiswa
import android.app.Application

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
    ContainerApp {
        override val repositoriSiswa: RepositoriSiswa by lazy {
            OfflineRepositoriSiswa(
                DatabaseSiswa.getDatabase(context).siswaDao()
            )
        }
    }

class AplikasiSiswa : Application() {
    /**
     * AppContainer instance digunakan oleh kelas-kelas di bawahnya untuk
     * menyediakan dependensi
     */


    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}