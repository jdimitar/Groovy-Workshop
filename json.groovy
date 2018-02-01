
http.request(GET, TEXT){
    headers.Accept = 'application/json'
    headers.'User-agent' = USER_AGENT
    response.success = { res, rd -> 
                            def jsonText = rd.text
                            def parser = new JsonSlurper().setType(JsonParserType.LAX)
                            def jsonResp = parser.parseText(jsonText)
                        }
}

//Parse JSON files with LAX type
import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText('{"name": "Json", "ID": "1"}')
println(object.name)
println(object.ID)

//Parsing list of integers
import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
Object list = jsonSlurper.parseText('{"List": [1, 2, 3, 4, 5]}')
list.each{ println it}

//Parsing list of primitive types
import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText ( '{"Integer":12, "fraction":12.33, "double": 12e145}')
println(object.Integer)
println(object.fraction)
println(object.double)


//JSON output
import groovy.json.JsonOutput

def output = JsonOutput.toJson([name: 'Josh', ID: 1])
println output

//JSON output from POJO
import groovy.json.JsonOutput

def output = JsonOutput.toJson([new Student(name: 'John', id: 1), 
                                new Student(name: 'Tom', id: 2) ])
println output

class Student{
    String name
    int id
}