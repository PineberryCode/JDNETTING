#!/bin/bash

#create a bin
if [ ! -d "/bin" ];
then
    #create a bin dir
    mkdir bin

    find src -name "*.java" -print | xargs javac -d bin
else
    find src -name "*.java" -print | xargs javac -d bin
fi

#Create an alias compiles 'java -cp bin Dev'
alias jdnet='java -cp bin Dev'