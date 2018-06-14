Feature: User tests RestAPIs
 @GET
 Scenario Outline: Verify the REST response after the GET request
    Given I have a Base URI <baseURI> and base path <basePath> for the REST API
    When I send the GET request to RestAPI
    Then the Rest API for GET should return me a valid response

 Examples:
    |   baseURI                                             |   basePath    |
    |   "http://restapi.demoqa.com/utilities/weather/city/" |   Noida       |
    |   "http://restapi.demoqa.com/utilities/weather/city/" |   Mumbai      |

 @POST
 Scenario Outline: Verify the REST response after the POST request
        Given I have a Base URI <baseURI> and base path <basePath> for the REST API and JSON file to post as <fileName>
        When I send the POST request to RestAPI
        Then the Rest API for POST should return me a valid response

 Examples:
    |   baseURI                                             |   basePath     |   fileName     |
    |   "http://localhost:9090/helios-ds-model-inbound/"    |   modelimport  |   "29556.json" |
    |   "http://localhost:9090/helios-ds-model-inbound/"    |   modelimport  |   "29557.json" |