# Getting Started

### About the app 
It is a sample Rest API of users data with below endpoints:
* '/users' - list of all users 
* '/user/{id}' - data of user with given id
* '/user/friends/{id}' - list of friends for given id
* '/user/suggestedFriends/{id}' - list of suggested friends for given id

### Installation steps
* download source code - git clone https://github.com/swathi9192/device-atlas.git 
* install neo4j server instance 
 On mac, run below commands 
  -> 'brew install neo4j'
  -> 'neo4j start' starts the db instance at http://localhost:7474 
  -> Goto http://localhost:7474 and change password to deviceatlas
 With docker,
 docker run -p7474:7474 -p7687:7687 -e NEO4J_AUTH=neo4j/deviceatlas neo4j
 
 Run the app and access the site at http://localhost:8081
 For api documentation, go to http://localhost:8081/swagger-ui/index.html
 
 
  

