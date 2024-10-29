package com.example.rickmorty.ui.navegation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickmorty.ui.screens.CharacterDetailScreen
import com.example.rickmorty.ui.screens.CharacterListScreen
import androidx.compose.ui.Modifier
import com.example.rickmorty.models.CharacterViewModel


@Composable
fun NavGraph(navController: NavHostController, viewModel: CharacterViewModel, modifier: androidx.compose.ui.Modifier = Modifier) {
    // Aquí aplica el modificador al contenedor de navegación, si es necesario
    Box(modifier = modifier) {
        NavHost(navController = navController, startDestination = "character_list") {
            composable("character_list") {
                CharacterListScreen(viewModel = viewModel) { characterId ->
                    navController.navigate("character_detail/$characterId")
                }
            }
            composable("character_detail/{characterId}") { backStackEntry ->
                val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                characterId?.let {
                    viewModel.loadCharacterById(it)
                    CharacterDetailScreen(viewModel = viewModel, characterId = it)
                }
            }
        }
    }
}

