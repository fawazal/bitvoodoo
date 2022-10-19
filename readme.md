# Getting Started

## The task :



#### developing a spring boot app that can create a Jira ticket in an Atlassian Cloud instance and shows the created ticket afterward.


* The only input parameter for the issue is the summary, no other field needs to be set



* The summary will be entered using Swagger ui to visualise the simple REST API (http://localhost:8080/swagger-ui.html)


* After the ticket was created via the Atlassian Rest API, the ticket should be shown as a JSON response in the SpringBoot app



## JiraController.kt

A controller class that is annotated with @RestController and has only one API to create a jira ticker
it takes a string as its only request param and return a response which is "ResponseObject" that has the url for the created ticket.
a Response Object is chosen as the return type and not simply an url string as it was requested that the controller should return a json that has the url in it, this also would make it easier to do further changes on what the api would return without changing the controller itself (we only need then to change the ResponseObject).
and it is worth noticing that a simillar approach could have been done for the request param; it could have been replaced with a Request Object.


## JiraService.kt

A service class that is annotated with @Service that implements the logic of a client that consumes the open REST Api of Jira.
it has the JiraConfig class, which read the needed configurations from the application.yml file, injected in it in the constructor. 
this service has only one function which plays the roll of a client that make the calls for the Jira Rest Api, it has JiraPayload as its parameter which represent the request object for the api call and it returns a response object.
Http headers are defined to do the basic authentication steps by passing the username and API token, and also the media type is set.
then a postForObject request is executed by HttpRequest with the created headers and the JiraPayload object.
and finally after that the ticket url is built and returned encapsulated in a ResponseObject