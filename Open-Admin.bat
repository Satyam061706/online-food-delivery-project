@echo off
title Foodies Admin Launcher
echo.
echo ==========================================
echo    Foodies Admin Panel Launcher
echo ==========================================
echo.

echo Checking if Foodies Application is running...
netstat -ano | findstr :8080 > nul
if %ERRORLEVEL% neq 0 (
    echo.
    echo [WARNING] The application does not seem to be running on localhost:8080.
    echo Please run Start-Foodies.bat first.
    echo.
    set /p choice="Try opening anyway? (y/n): "
    if /i "%choice%" neq "y" exit /b
)

echo.
echo Opening Admin Panel in your browser...
start http://localhost:8080/admin

echo.
echo Done.
timeout /t 5
