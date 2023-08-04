#!/bin/bash

#create a bin dir
mkdir bin

#create a bin
find src -name "*.java" -print | xargs javac -d bin

#Create an alias compiles 'java -cp bin Dev'
alias jdnet='java -cp bin Dev'