package com.example.meet7_roomdatabase.view.route

import com.example.meet7_roomdatabase.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "idem_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}