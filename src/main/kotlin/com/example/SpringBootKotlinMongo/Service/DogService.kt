package com.example.SpringBootKotlinMongo.Service

import com.example.SpringBootKotlinMongo.Model.Dog
import com.example.SpringBootKotlinMongo.Repository.DogDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DogService {
	@Autowired
	lateinit var dogDAO: DogDAO

	fun getAllDogs(): List<Dog>{
		return dogDAO.getAllDogs()

	}

	fun getDogById(id: Int): Dog {
		return dogDAO.getDogById(id)

	}
	fun findDogByName(name: String):Dog{
		return dogDAO.findDogByName(name)
	}
	fun createDog(dog:Dog): Dog {
		return dogDAO.createDog(dog)

	}


}