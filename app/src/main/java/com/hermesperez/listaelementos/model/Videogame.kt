package com.hermesperez.listaelementos.model

data class Videogame(
    val title: String = "",
    val author: String = "",
    var favourite: Boolean = false
){
    companion object{
        fun getData() : List<Videogame>{
            return listOf(

                Videogame("The Legend of Zelda", "Nintendo", false),
                Videogame("God of War", "Santa Monica Studio", false),
                Videogame("Fortnite", "Epic Games", false),
                Videogame("Minecraft", "Mojang", false),
                Videogame("Overwatch", "Blizzard Entertainment", false),
                Videogame("Cyberpunk 2077", "CD Projekt", false),
                Videogame("Assassin's Creed Valhalla", "Ubisoft", false),
                Videogame("FIFA 22", "EA Sports", false),
                Videogame("The Witcher 3: Wild Hunt", "CD Projekt", false),
                Videogame("Call of Duty: Warzone", "Infinity Ward", false),
                Videogame("Grand Theft Auto V", "Rockstar North", false),
                Videogame("Red Dead Redemption 2", "Rockstar Games", false),
                Videogame("The Elder Scrolls V: Skyrim", "Bethesda Game Studios", false),
                Videogame("League of Legends", "Riot Games", false),
                Videogame("Dota 2", "Valve", false),
                Videogame("Counter-Strike: Global Offensive", "Valve", false),
                Videogame("Super Mario Odyssey", "Nintendo", false),
                Videogame("Spider-Man", "Insomniac Games", false),
                Videogame("Pokemon Sword and Shield", "Game Freak", false),
                Videogame("Among Us", "InnerSloth", false),
                Videogame("Animal Crossing: New Horizons", "Nintendo", false)
            )
        }
    }
}


