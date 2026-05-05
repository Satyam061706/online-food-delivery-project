@echo off
title Foodies Application Launcher
echo Starting Foodies Application...
echo Please ensure MongoDB is running on localhost:27017
echo.

:: Using -Xmx512m to limit heap and help avoid native memory exhaustion on low-RAM systems
java -Xmx512m -jar foodies-app.jar
if %ERRORLEVEL% neq 0 (
    echo.
    echo ==========================================
    echo   ERROR: Application failed to start.
    echo ==========================================
    echo Possible causes:
    echo 1. Java is not installed or not in PATH.
    echo 2. MongoDB is not running on localhost:27017.
    echo 3. Another application is using port 8080.
    echo 4. System is out of memory (check for hs_err_*.log files).
    echo.
    pause
)
pause
