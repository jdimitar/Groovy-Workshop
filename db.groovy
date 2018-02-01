//Databases

import java.sql.*
import groovy.sql.Sql

@GrabConfig(systemClassLoader=true)
@Grab(group='org.postgresql', module='postgresql', version='9.4-1205-jdbc42')

def dbUrl      = "jdbc:postgresql://localhost:5432/petclinic"
def dbUser     = "postgres"
def dbPassword = "iskratel"
def dbDriver   = "org.postgresql.Driver"

def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
sql.eachRow('SELECT VERSION()'){println it[0]}

//Create Table Movies
def query = """CREATE TABLE MOVIES (
                      TITLE CHAR(40) NOT NULL,
                      MYEAR CHAR(20),
                      TYPE CHAR(40),
                      FORMAT CHAR(20),
                      YEAR CHAR(4),
                      RATING CHAR(10),
                      STARS CHAR(20) )"""
sql.execute(query)

//Create Table
def query = """CREATE TABLE EMPLOYEE (
                      FIRST_NAME CHAR(20) NOT NULL,
                      LAST_NAME CHAR(20),
                      AGE INT,
                      SEX CHAR(1),
                      INCOME FLOAT )"""
//sql.execute(query)

//Insert statement
def firstname="Dimitar"
def lastname ="Josifov"
def age=20
def sex="M"
def income=2000

def insert = """
                INSERT INTO EMPLOYEE(FIRST_NAME, LAST_NAME, AGE, SEX, INCOME) VALUES 
                (${firstname}, ${lastname}, ${age}, ${sex}, ${income} ) """
try{
    sql.execute(insert)
    //sql.commit()
    println("Successfully inserted")
    } catch(Exception ex){
    sql.rollback()
    println("Transaction rollback")
    }
sql.close()