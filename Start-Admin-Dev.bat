@echo off
title Foodies Admin - Development Mode
echo.
echo ==========================================
echo    Foodies Admin Development Server
echo ==========================================
echo.

cd adminpanel
echo Installing dependencies if needed...
if not exist node_modules (
    call npm.cmd install
)

echo.
echo Starting Vite development server...
echo The admin panel will be available at http://localhost:5173/admin/
echo.

start http://localhost:5173/admin/
call npm.cmd run dev
pause
