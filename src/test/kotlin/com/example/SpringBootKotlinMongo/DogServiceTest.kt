package com.example.SpringBootKotlinMongo

import com.example.SpringBootKotlinMongo.Model.Dog
import com.example.SpringBootKotlinMongo.Repository.DogDAO
import com.example.SpringBootKotlinMongo.Service.DogService
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DogServiceTest {

	private val dogService: DogService = mockk(relaxed=true)
	@Test
	@DisplayName("Test Service to get all dogs")
	fun `should get all dogs`(){
		val response = dogService.getAllDogs()
		assertThat(response.size>0)
	}
	@Test
	@DisplayName("Test Service to get dog by id")
	fun `get a dog by its id`(){
		val id: Int=1
		val response = dogService.getDogById(id)
		assertThat(response.id.equals(1))
	}
	@Test
	@DisplayName("Test Service to create a dog")
	fun `should get a new dog`(){
		val dog = Dog(3, "Sam",12,"D")
		val response = dogService.createDog(dog)
		assertThat(response.name.equals("Sam") )
	}
}