package com.example.meet7_roomdatabase.viewmodel

import com.example.meet7_roomdatabase.room.Siswa
import com.example.meet7_roomdatabase.repositori.RepositoriSiswa
import androidx.lifecycle.ViewModel

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
    }
}
data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telepon: String = "",
)
/*fungsi untuk mengkonversi data input ke data dlm tabel sesuai jenis datanya*/
fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telepon = telepon
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telepon = telepon
)