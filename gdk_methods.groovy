// GDK Methods
// ----------------------------------------------------------------------

assert 2 == 2.5.toInteger() // conversion
assert 2 == 2.5 as Integer  // enforced coercion
assert 2 == (int) 2.5 // cast

assert '5.50'.isNumber()
assert 5 == '5'.toInteger()

// times | upto | downto | step

20.times { print '-' }

1.upto(10) { num -> println num }

10.downto(1) { num -> println num }

0.step(1,0.1) { num -> println num }

// dollar slashy

String slashy = /a\b/
String url = $/http://google.com/image/$
println url

println slashy.class

def pattern = ~/a\b/
println pattern.class

// Find | Match

def text = "Apache Groovy is a powerful, optionally typed and dynamic language, with static-typing and static compilation capabilities. " // true
def pattern = ~/powerful,/
def finder = text =~ pattern
def matcher = text ==~ pattern

println finder
println finder.size()
println matcher
