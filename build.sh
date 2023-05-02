#!/bin/bash
cd competition || exit
echo "Starting build..."
mvn clean package
if [ $? -eq 0 ]; then
    echo "Build successful"
else
    echo "Build failed"
fi