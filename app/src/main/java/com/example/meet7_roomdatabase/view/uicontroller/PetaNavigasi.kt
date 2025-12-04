package com.example.meet7_roomdatabase.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meet7_roomdatabase.view.EntrySiswaScreen
import com.example.meet7_roomdatabase.view.HomeScreen
import com.example.meet7_roomdatabase.view.route.DestinasiEntry
import com.example.meet7_roomdatabase.view.route.DestinasiHome
import com.example.meet7_roomdatabase.view.route.DestinasiDetailSiswa
import androidx.navigation.NavType
import com.example.meet7_roomdatabase.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.meet7_roomdatabase.view.DetailSiswaScreen
import androidx.navigation.navArgument
import com.example.meet7_roomdatabase.view.route.DestinasiEditSiswa
import com.example.meet7_roomdatabase.view.EditSiswaScreen

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {

        // HOME
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },

                // edit 1: tambahkan navigation ke detail
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/$it")
                }
            )
        }

        // ENTRY
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        // DETAIL
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(itemIdArg) { type = NavType.IntType }
            )
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEditSiswa.route}/$id")
                },
                navigateBack = { navController.navigateUp() }
            )
        }

        // EDIT
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
