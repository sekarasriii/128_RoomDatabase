package com.example.meet7_roomdatabase.viewmodel.provider

import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewmodel.initializer
import com.example.meet7_roomdatabase.viewmodel.HomeViewModel
import com.example.meet7_roomdatabase.viewmodel.EntryViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import  com.example.meet7_roomdatabase.repositori.AplikasiSiswa
import androidx.lifecycle.ViewModelProvider

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek (application) dan mengembalikan sebuah instance dari [AplikasiSiswa]
 */

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
