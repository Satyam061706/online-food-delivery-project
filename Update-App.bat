@echo off
echo ==========================================
echo    Foodies App Update Script
echo ==========================================
echo.

echo [1/5] Building Main React Frontend...
cd foodies
call npm.cmd run build
if %ERRORLEVEL% neq 0 (
    echo.
    echo ERROR: Main React build failed.
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [2/5] Building Admin Panel...
cd ..\adminpanel
call npm.cmd run build
if %ERRORLEVEL% neq 0 (
    echo.
    echo ERROR: Admin Panel build failed.
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [3/5] Syncing files to Backend...
cd ..
powershell -Command "Remove-Item -Path 'foodiesapi\src\main\resources\static\*' -Recurse -Force -ErrorAction SilentlyContinue"
powershell -Command "Copy-Item -Path 'foodies\dist\*' -Destination 'foodiesapi\src\main\resources\static\' -Recurse -Force"
powershell -Command "New-Item -ItemType Directory -Force -Path 'foodiesapi\src\main\resources\static\admin'"
powershell -Command "Copy-Item -Path 'adminpanel\dist\*' -Destination 'foodiesapi\src\main\resources\static\admin\' -Recurse -Force"

echo.
echo [4/5] Building Backend JAR (Maven)...
cd foodiesapi
call mvnw.cmd clean package -DskipTests
if %ERRORLEVEL% neq 0 (
    echo.
    echo ERROR: Maven build failed.
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [5/5] Updating main foodies-app.jar...
cd ..
copy /Y "foodiesapi\target\foodiesapi-0.0.1-SNAPSHOT.jar" "foodies-app.jar"

echo.
echo ==========================================
echo   SUCCESS! Your changes are now live.
echo   Run Start-Foodies.bat to start the app.
echo ==========================================
pause
