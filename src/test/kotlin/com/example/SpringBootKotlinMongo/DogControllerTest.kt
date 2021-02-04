package com.example.SpringBootKotlinMongo

import com.example.SpringBootKotlinMongo.Model.Dog
import com.fasterxml.jackson.databind.ObjectMapper
import mu.KLogging
import org.junit.jupiter.api.Assertions.assertTrue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import mu.KotlinLogging
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.RestClientException

import kotlin.test.assertFailsWith
private val logger = KotlinLogging.logger{}
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(SpringExtension::class)
@AutoConfigureMockMvc
class DogControllerTest  @Autowired constructor (
  val mockMvc : MockMvc,
  val objectMapper:ObjectMapper,
  val restTemplate: TestRestTemplate
) {
	//@LocalServerPort
	//var serverPort: Int = 0

	@DisplayName("GET /dogs")
	@Test
	fun `should return all dogs`() {

		mockMvc.get("/dogs")
			.andDo { print() }
			//then
			.andExpect {
				status { isOk() }
				content { contentType(MediaType.APPLICATION_JSON) }
				jsonPath("$[0].name") { value("Meg") }
			}

	}

	@DisplayName("GET /dogs/1")
	@Test
	fun `should return one dog by id`() {
		//given
		val id = 1
		//when
		mockMvc.get("/dogs/$id")
			.andDo { print() }
			//then
			.andExpect {
				status { isOk() }
				content { contentType(MediaType.APPLICATION_JSON) }
				jsonPath("$.name") { value("Meg") }
				jsonPath("$.age") { value(9) }
			}

	}

	@DisplayName("get dog by name")
	@Test
	fun `get dog with name Meg`() {
		val name = "Meg"
		mockMvc.get("/dogs/name/$name")
			.andDo { print() }
			.andExpect {
				status { isOk() }
				content { contentType(MediaType.APPLICATION_JSON) }
				jsonPath("$.sex") { value("B") }
				jsonPath("$.age") { value(9) }
			}
	}

	@Test
	@DisplayName("Test Description")
	fun `should return error if no dog exists` () {
	//given
	val id:Int = 99
	//when
	assertFailsWith<RestClientException>(
		block = {
		val response = restTemplate.getForEntity(
			"/dogs/$id",
			Dog::class.java
		)
	})
}
}