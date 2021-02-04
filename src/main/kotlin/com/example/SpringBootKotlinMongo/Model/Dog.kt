package com.example.SpringBootKotlinMongo.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="Dogs")
data class Dog (
	@Id
	val id:Int,
	val name:String,
	val age: Int,
	val sex: String
)

class DogRequest(
	@Id
	val id:Int,
	val name:String,
	val age: Int,
	val sex: String
)