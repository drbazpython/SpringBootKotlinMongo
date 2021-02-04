package com.example.SpringBootKotlinMongo.Controller

import com.example.SpringBootKotlinMongo.Model.Dog
import com.example.SpringBootKotlinMongo.Model.DogRequest
import com.example.SpringBootKotlinMongo.Repository.DogRepository
import com.example.SpringBootKotlinMongo.Service.DogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/dogs")
class DogController {
	@Autowired
	lateinit var dogService: DogService

	@ExceptionHandler(NoSuchElementException::class)
	fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
		ResponseEntity(e.message, HttpStatus.NOT_FOUND)

	@ExceptionHandler(IllegalArgumentException::class)
	fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
		ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

	@GetMapping
	fun getAllDogs(): ResponseEntity<List<Dog>> {
		val dogs = dogService.getAllDogs()
		return ResponseEntity.ok(dogs)
	}

	@GetMapping("/{id}")
	fun getDogById(@PathVariable("id") id: Int): ResponseEntity<Dog> {
		val dog = dogService.getDogById(id)
		return ResponseEntity.ok(dog)
	}

	@GetMapping("/name/{name}")
	fun getDogByName(@PathVariable("name") name: String): ResponseEntity<Dog>{
	val dog = dogService.findDogByName(name)
	return ResponseEntity.ok(dog)
}
	@PostMapping
	fun createDog(@RequestBody  dog: Dog): ResponseEntity<Dog>{
		val dog1 = dogService.createDog(dog)
		return ResponseEntity.ok(dog1)
	}
}