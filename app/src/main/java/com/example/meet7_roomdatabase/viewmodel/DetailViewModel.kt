package com.example.meet7_roomdatabase.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.example.meet7_roomdatabase.repositori.RepositoriSiswa
import androidx.lifecycle.ViewModel
import com.example.meet7_roomdatabase.view.route.DestinasiDetailSiswa

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa) : ViewModel() {
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])}
