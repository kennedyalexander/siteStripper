# Write some documentation 

# Coding Challenge

## Slot machine

Welcome to my slot machine. 
It consumes JSON


## Basic workflow

Send it a user, userToken
User is your userName, 
userToken is given to you when you logon(currently not implemented random string works),

It returns your Roll along with weather you won or lost.

### Implemented Features 

Get all Rolls for a user
Do a new roll
H2 Database span up on initalisation
Building App BashScript

### Planned Features

Login using spring security
More detailed Metrics
Betting mechanic
Service Layer tests

## Example Requests

Request - http://localhost:8080/roll

{
"username": "username","userToken": "dasds","userBet": "1"
}


Response -

{
"winStatus": "LOSE",
"roller1": "BANANA",
"roller2": "APPLE",
"roller3": "APPLE"
}

**This has decided to stop working**
Request - http://localhost:8080/getRollsForUser

{
"username": "username"
}

Response - 

{
"userSpin": {
"winStatus": "LOSE",
"roller1": "APPLE",
"roller2": "BANANA",
"roller3": "CITRUS"
},
"userRequest": {
"username": "oranges",
"userToken": "usertoken",
"userBet": 0
}
}

# Functions

/roll(username, userToken, betValue) 
-> rollers
-> win/lose
-> rollTime
-> userToken


/login(username, password)
-->http success/fail

/getRollHistory(username)
-> List
	-> rollers
	-> win/lose
	-> rollTime
	-> userToken

/logout(username, userToken)
--> http success/fail

# Objects

Incoming requests from a user are handled in a UserRequest this allows you to almost always expect the same data
UserRequest
-> username String its a unique ID in my system
-> userToken Given on login enables you to see what has gone on in this session not used for much yet and so will be auto filled for now.

Incoming Login requests are special and so have their own object

Controller -> (Spin) ->


