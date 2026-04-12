@echo off
setlocal

REM Set Java environment explicitly
set "JAVA_HOME=C:\Program Files\Java\jdk1.8.0_111"
set "PATH=%JAVA_HOME%\bin;%PATH%"

REM Set project paths
set "PROJECT_ROOT=c:\Users\user\OneDrive\Pictures\Dishcovery-2026"
set "BUILD_DIR=%PROJECT_ROOT%\build\classes"

echo ==========================================
echo Running Admin class
echo ==========================================
echo.

REM Run the Admin class
cd /d "%PROJECT_ROOT%"
"%JAVA_HOME%\bin\java" -cp "%BUILD_DIR%" dishcovery.Admin 2>&1

set RUN_RESULT=%ERRORLEVEL%

echo.
echo ==========================================
if %RUN_RESULT% EQU 0 (
    echo Execution completed successfully
) else (
    echo Execution failed with exit code %RUN_RESULT%
)
echo ==========================================

endlocal
