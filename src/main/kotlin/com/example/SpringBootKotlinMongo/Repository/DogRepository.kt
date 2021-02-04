package com.example.SpringBootKotlinMongo.Repository

import com.example.SpringBootKotlinMongo.Model.Dog
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
@Repository
interface DogRepository  : MongoRepository<Dog,Int>{
fun findOneById(id:Int):Dog
fun findDogByName(name:String): Dog
}