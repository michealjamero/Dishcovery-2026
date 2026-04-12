@echo off
setlocal EnableDelayedExpansion

REM Set Java environment explicitly
set "JAVA_HOME=C:\Program Files\Java\jdk1.8.0_111"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo ==========================================
echo Java Environment Setup
echo ==========================================
echo JAVA_HOME: %JAVA_HOME%
echo.

REM Verify Java is accessible
"%JAVA_HOME%\bin\java" -version 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Java is not accessible
    exit /b 1
)
echo.

REM Set project paths
set "PROJECT_ROOT=c:\Users\user\OneDrive\Pictures\Dishcovery-2026"
set "SRC_DIR=%PROJECT_ROOT%\src"
set "BUILD_DIR=%PROJECT_ROOT%\build\classes"

echo ==========================================
echo Project Paths
echo ==========================================
echo Source: %SRC_DIR%
echo Build: %BUILD_DIR%
echo.

REM Create build directory if it doesn't exist
if not exist "%BUILD_DIR%" mkdir "%BUILD_DIR%"

REM Build classpath
set "CLASSPATH=%BUILD_DIR%"

REM Find all Java source files
echo ==========================================
echo Finding Java source files...
echo ==========================================
set "JAVA_FILES="
for /r "%SRC_DIR%" %%f in (*.java) do (
    set "JAVA_FILES=!JAVA_FILES! "%%f""
)

echo Found Java files. Compiling...
echo.

REM Compile all Java files
echo ==========================================
echo Compiling all Java files...
echo ==========================================
"%JAVA_HOME%\bin\javac" -cp "%CLASSPATH%" -d "%BUILD_DIR%" %JAVA_FILES% 2>&1

set COMPILE_RESULT=%ERRORLEVEL%

if %COMPILE_RESULT% NEQ 0 (
    echo.
    echo COMPILATION FAILED with error code %COMPILE_RESULT%
    exit /b 1
) else (
    echo.
    echo COMPILATION SUCCESSFUL
)

echo.
echo ==========================================
echo Listing compiled classes:
echo ==========================================
dir /s /b "%BUILD_DIR%\*.class" | findstr /i admin

echo.
echo ==========================================
echo Done.
echo ==========================================

endlocal
