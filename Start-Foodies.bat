@echo off
title Foodies Application Launcher
echo Starting Foodies Application...
echo Please ensure MongoDB is running on localhost:27017
echo.
java -jar foodies-app.jar
if %ERRORLEVEL% neq 0 (
    echo.
    echo Application failed to start. Please check if Java is installed and MongoDB is running.
    pause
)
pause
