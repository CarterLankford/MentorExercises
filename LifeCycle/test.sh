#!/usr/bin/bash
# find . -name *Test.class | cut -d '.' -f1 | java
find . -name *TimeTest.class | cut -d '.' -f1 | java -cp "./target/classes;./target/test-classes" priv.exercises.datetime.RunTests
# find . -name *TimeTest.class | cut -d '.' -f1 | java -cp "./target/classes;./target/test-classes" priv.exercises.datetime.TimeTest