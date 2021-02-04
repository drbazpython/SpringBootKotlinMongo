package com.example.SpringBootKotlinMongo.Repository

import com.example.SpringBootKotlinMongo.Model.Dog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
class DogDAO {
	@Autowired
	lateinit var dogRepository:DogRepository

	fun getAllDogs(): List<Dog> {
		return dogRepository.findAll()
	}

	fun getDogById(id: Int): Dog {
		return dogRepository.findOneById(id)

	}
	fun findDogByName(name:String) :Dog{
		return dogRepository.findDogByName(name)
	}
	fun createDog(dog:Dog): Dog{
		return dogRepository.insert(dog)

	}


}