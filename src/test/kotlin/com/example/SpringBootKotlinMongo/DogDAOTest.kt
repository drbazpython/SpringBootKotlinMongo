package com.example.SpringBootKotlinMongo

import com.example.SpringBootKotlinMongo.Model.Dog
import com.example.SpringBootKotlinMongo.Repository.DogDAO
import com.example.SpringBootKotlinMongo.Repository.DogRepository
import com.example.SpringBootKotlinMongo.Service.DogService
import org.springframework.data.mongodb.repository.MongoRepository
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DogDAOTest {
	private val dogDAO: DogDAO = mockk(relaxed=true)
	@Test
	@DisplayName("Test DAO to return all dogs")
	fun `should get all dogs` () {
	//when
	val response = dogDAO.getAllDogs()
	//then
	assertThat(response.isNotEmpty())
	}
	@Test
	@DisplayName("Test DAO to return one dog by id")
	fun `should get one dog by id`(){
		val id: Int=99
		val dog = dogDAO.getDogById(id)
		//assertNotNull(dog)
		Assertions.assertEquals(0,dog.id)
		Assertions.assertEquals("", dog.name)
	}
	@Test
	@DisplayName("Test DAO to create a dog")
	fun `should get a new dog`(){
		val dog = Dog(3, "Sam",12,"D")
		val response = dogDAO.createDog(dog)
		assertThat(response.name.equals("Sam") )
	}
}