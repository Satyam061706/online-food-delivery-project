@echo off
echo ==========================================
echo    Foodies App Update Script
echo ==========================================
echo.

echo [1/4] Building React Frontend...
cd foodies
call npm.cmd run build
if %ERRORLEVEL% neq 0 (
    echo.
    echo ERROR: React build failed.
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [2/4] Syncing files to Backend...
powershell -Command "Remove-Item -Path '..\foodiesapi\src\main\resources\static\*' -Recurse -Force -ErrorAction SilentlyContinue"
powershell -Command "Copy-Item -Path 'dist\*' -Destination '..\foodiesapi\src\main\resources\static\' -Recurse -Force"

echo.
echo [3/4] Building Backend JAR (Maven)...
cd ..\foodiesapi
call mvnw.cmd clean package -DskipTests
if %ERRORLEVEL% neq 0 (
    echo.
    echo ERROR: Maven build failed.
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [4/4] Updating main foodies-app.jar...
cd ..
copy /Y "foodiesapi\target\foodiesapi-0.0.1-SNAPSHOT.jar" "foodies-app.jar"

echo.
echo ==========================================
echo   SUCCESS! Your changes are now live.
echo   Run Start-Foodies.bat to start the app.
echo ==========================================
pause
