# Thortful/Velv exercise

This project exposes a single endpoint that fetches today trending movies from **[TMDB](https://developer.themoviedb.org/reference/trending-movies)** public API.
A single property from a movie is exposed which is the **origin title**
The value of this exercise lies in the consumption of a public API and have a REST API upfront.

# Layout

Project developed using a hexagonal architecture.

## Tech key notes

 - Spring Boot 2.6
 - Java 11 (chosen due to compatibility with Lombok/Jackson tooling)
 - There is no persistence layer
 - It uses my own TMDB personal API access token (ouch!)

## How to run it

 - Having it locally project can be compiled and using Gradle clean compile app:bootRun
 - The docker way to do it is described inside file **docker/thortful/docker-setup.README**

## Sample API calls
Requires *curl* and *jq* command line tools installed.
Modify page number to use pagination (page=<NUMBER>)

### Trending movies api

    curl -v -XGET -H "Content-type: application/json" 'http://localhost:8089/api/trending/movies?page=1' | jq .

### Same call of trending movies API in TMDB

    curl --request GET \                                                                              
     --url 'https://api.themoviedb.org/3/trending/movie/day?language=en-US&page=1' \
     --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzZDg4NWY2OWU5NzQ3YTM3YzY0YmM3MmVjOTY2Y2YwMiIsIm5iZiI6MTcyMDAxMzM1MC44NDY2ODQsInN1YiI6IjUyNTdjZTc1NzYwZWUzNzMwNzA0MjlhMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.U65F-bOQ2KkydfakMU9jLzQ6vWR65oKYKQpvmhs0ylk' \
     --header 'accept: application/json' | jq .

## How it could evolve

 - Increase test coverage
 - File naming
 - Fetching more data
 - Use generated converter classes using MapStruct
 - Integration of a caching engine(distributed or per running instance)
 - Integration of a persistence engine
 - Usage of a message bus or message broker as an async way to feed caching/persistence layer
 - Kubernetize it!
