#!/usr/bin/bash
if [ ! -d target ]; then
    mkdir target
fi

if [ ! -d target/classes ]; then
    mkdir target/classes
fi

if [ ! -d target/test-classes ]; then
    mkdir target/test-classes
fi


find ./src/ -name "*.java" | xargs javac -d target/classes && find ./test/ -name "*.java" | xargs javac -d target/test-classes -cp target/classes
# return $?
