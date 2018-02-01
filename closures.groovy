//Closures

def clos = { param -> println "Hello, $param "}

clos("Dimitar")

clos.call("World")


//Closures with Maps
def mp =  ["TopicName" : "Maps", "TopicDescription" : "Methods in Maps"]
mp.each {println it}
mp.each {println "${it.key} maps to ${it.value}"}

def lst = [1,2,3,4]
println("Numbers divided by 2 are:")
lst.each{ if(it % 2 == 0) println it}

lst.each{ if(it > 2) println it}
//collect
even = lst.collect{ if(it % 2 == 0) return it }
println even

