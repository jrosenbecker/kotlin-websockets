package com.joerosenbecker.kotlinwebsockets.controllers;

import com.joerosenbecker.kotlinwebsockets.contracts.ArtistService
import com.joerosenbecker.kotlinwebsockets.viewmodels.ArtistViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/artists")
@CrossOrigin
public class ArtistController {
	@Autowired
	lateinit var artistService: ArtistService

	@GetMapping("")
	fun getAllArtists(): MutableList<ArtistViewModel> {
		return this.artistService.getAllArtists()
	}

	@GetMapping("/{artistId}")
	fun getArtist(@PathVariable("artistId") artistId: Int): ArtistViewModel {
		return this.artistService.getArtist(artistId);
	}
}
