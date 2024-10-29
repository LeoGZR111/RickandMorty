package com.example.rickmorty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.rickmorty.models.CharacterViewModel

@Composable
fun CharacterDetailScreen(viewModel: CharacterViewModel, characterId: Int) {
    val character = viewModel.selectedCharacter.collectAsState().value

    character?.let {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Image(
                painter = rememberImagePainter(data = it.image),
                contentDescription = it.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(240.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.name, style = MaterialTheme.typography.headlineLarge)
            Text(text = "Status: ${it.status}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Species: ${it.species}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Gender: ${it.gender}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
