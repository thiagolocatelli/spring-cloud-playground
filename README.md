## Spring cloud Playgroud - Simple Movie Experience

## Applications and Services

### Micro Services

##### user-service (port 8081)

| API                       | HTTP Method   |  Description |
|---------------------------|---------------|--------------|
| /api/v1/user              | POST          |  Creates or updates an user |
| /api/v1/user/{userId}     | GET           |  Retrieves an user object |
| /api/v1/uses              | GET           |  Retrieves the list of users |


##### movie-service (port 8082)

| API                       | HTTP Method   |  Description |
|---------------------------|---------------|--------------|
| /api/v1/movie             | POST          |  Creates or updates a movie |
| /api/v1/movie/{movieId}   | GET           |  Retrieves a movie object |
| /api/v1/movies            | GET           |  Retrieves the list of movies |


##### rating-service (port 8083)

| API                                   | HTTP Method   |  Description |
|---------------------------------------|---------------|--------------|
| /api/v1/rating                        | POST          |  Creates a movie rating |
| /api/v1/ratings/user/{userId}         | GET           |  Retrieves the list of ratings for an user |
| /api/v1/ratings/movies/{movieId}      | GET           |  Retrieves the list of ratings for a movie |
| /api/v1/ratings/{userId}/{movieId}    | GET           |  Retrieves a rating for an user and movie |


##### cart-service (port 8084)

| API                               | HTTP Method   |  Description |
|-----------------------------------|---------------|--------------|
| /api/v1/cart                      | POST          |  Creates a cart item |
| /api/v1/cart/{userId}             | GET           |  Retrieves the list of cart items for an user |
| /api/v1/cart/{userId}/{movieId}   | GET           |  Retrieves a cart item for an user and movie |


### Cloud Services

#### Portainer (port 9999)

#### Discovery Server - Eureka (port 8888)

#### Api Gateway - Spring Cloud Gateway (port 9000)

#### Proxy Gateway - Zuul Proxy (port 9001)


## Working with it

#### Downloading and running localy

#### Deploying to Docker

#### Deploying to Docker Swarm