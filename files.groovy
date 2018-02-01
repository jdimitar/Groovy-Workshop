//Operations with FILE IO

//Reading file
//1. with closure
import java.io.File
class Example {
    static void main(String[] args){
         new File("C:/test/star_wars.txt").eachLine{
             line -> println "line : $line";}
    }
}

//2. directly
class Example{
    static void main(String[] args){
        File file = new File("C:/test/star_wars.txt")
        println file.text
        }
}


//Writing files
new File('C:/test/','example.txt').withWriter('utf-8'){
             writer -> writer.writeLine 'Hello World'}

//get size of file
File file = new File("C:/test/star_wars.txt")
println "The file ${file.absolutePath} has ${file.length()} bytes"

//test if file is directory
def file = new File('C:/test/star_wars.txt')
 println "File? ${file.isFile()}"
 println "Directory? ${file.isDirectory()}"
 
 //Create directory
 def file = new File('C:/test/dimitar')
 file.mkdir()
 //delete file
 file.delete()
 
 //copy file
 def src = new File("C:/test/star_wars.txt")
 def dst = new File("C:/test/copy.txt")
 dst << src.text
 
 //getting directory content
 def rootFiles = new File("C:/test/").listRoots()
 rootFiles.each{ println it.absolutePath }
 
 new File("C:/test/").eachFile(){ println it.getAbsolutePath()}
 
 
 
 
 
 
