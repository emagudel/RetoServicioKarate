Feature: Get services of the page jsonplaceholder.typicode.com

  Background:
    * configure ssl = true
    * def token = '0a46c6930d3e705cc070838a78614ba7abde0282'
    * def headerData = {Authorization: #(token), Accept: 'application/json'}
    * headers headerData

  Scenario: Get right data for first service
    Given url 'https://jsonplaceholder.typicode.com/posts'
    When request
    Then method GET
    And def serviceResponse1 = read('datajson/serviceResponse01.json')
    And match response == serviceResponse1


  Scenario: Get right data for second service
    Given url 'https://jsonplaceholder.typicode.com/comments'
    When request
    Then method GET
    And def serviceResponse2 = read('datajson/serviceResponse02.json')
    And match response == serviceResponse2


  Scenario: Get right data for third service
    Given url 'https://jsonplaceholder.typicode.com/comments?postId=1'
    When request
    Then method GET
    And def serviceResponse3 = read('datajson/serviceResponse03.json')
    And match response == serviceResponse3


  Scenario: Compare data from service three with service one
    Given url 'https://jsonplaceholder.typicode.com/comments?postId=1'
    When request
    Then method GET
    And def serviceResponse1 = read('datajson/serviceResponse01.json')
    And def serviceResponse2 = read('datajson/serviceResponse02.json')
    And def serviceResponse3 = read('datajson/serviceResponse03.json')
    And match response == serviceResponse3
    And match response[0].name contains serviceResponse1[0].name
    And match response[0].email contains serviceResponse1[0].email
    And match response[0].body contains serviceResponse1[0].body


  Scenario: Compare data from service three with service two
    Given url 'https://jsonplaceholder.typicode.com/comments?postId=1'
    When request
    Then method GET
    And def serviceResponse1 = read('datajson/serviceResponse01.json')
    And def serviceResponse2 = read('datajson/serviceResponse02.json')
    And def serviceResponse3 = read('datajson/serviceResponse03.json')
    And match response == serviceResponse3
    And match response[0].name contains serviceResponse2[0].name
    And match response[0].email contains serviceResponse2[0].email
    And match response[0].body contains serviceResponse2[0].body





