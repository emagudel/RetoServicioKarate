Feature: Get services of the page jsonplaceholder.typicode.com

  Background:
    * configure ssl = true
    * def token = '0a46c6930d3e705cc070838a78614ba7abde0282'
    * def headerData = {Authorization: #(token), Accept: 'application/json'}
    * headers headerData

  Scenario Outline: Compare data from service three with service one
    Given url 'https://jsonplaceholder.typicode.com/comments?postId=1'
    When request
    Then method GET
    And def serviceResponse1 = read('datajson/serviceResponse01.json')
    And def serviceResponse2 = read('datajson/serviceResponse02.json')
    And def serviceResponse3 = read('datajson/serviceResponse03.json')
    And match response == serviceResponse3
    And match response[<posicion>].name contains serviceResponse1[<posicion>].name
    And match response[<posicion>].email contains serviceResponse1[<posicion>].email
    And match response[<posicion>].body contains serviceResponse1[<posicion>].body

    Examples:
      | posicion |
      | 0        |
      | 1        |
      | 2        |
      | 3        |
      | 4        |


  Scenario Outline: Compare data from service three with service two
    Given url 'https://jsonplaceholder.typicode.com/comments?postId=1'
    When request
    Then method GET
    And def serviceResponse1 = read('datajson/serviceResponse01.json')
    And def serviceResponse2 = read('datajson/serviceResponse02.json')
    And def serviceResponse3 = read('datajson/serviceResponse03.json')
    And match response == serviceResponse3
    And match response[<posicion>].name contains serviceResponse2[<posicion>].name
    And match response[<posicion>].email contains serviceResponse2[<posicion>].email
    And match response[<posicion>].body contains serviceResponse2[<posicion>].body

    Examples:
      | posicion |
      | 0        |
      | 1        |
      | 2        |
      | 3        |
      | 4        |





