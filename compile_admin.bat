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
set "LIB_DIR=%PROJECT_ROOT%\lib"

echo ==========================================
echo Project Paths
echo ==========================================
echo Source: %SRC_DIR%
echo Build: %BUILD_DIR%
echo Lib: %LIB_DIR%
echo.

REM Create build directory if it doesn't exist
if not exist "%BUILD_DIR%" mkdir "%BUILD_DIR%"

REM Build classpath
set "CLASSPATH=%BUILD_DIR%"
if exist "%LIB_DIR%" (
    for %%j in ("%LIB_DIR%\*.jar") do (
        set "CLASSPATH=!CLASSPATH!;%%j"
    )
)

echo ==========================================
echo Classpath: %CLASSPATH%
echo ==========================================
echo.

REM Compile Admin.java
echo ==========================================
echo Compiling Admin.java...
echo ==========================================
"%JAVA_HOME%\bin\javac" -cp "%CLASSPATH%" -d "%BUILD_DIR%" "%SRC_DIR%\dishcovery\Admin.java" 2>&1

set COMPILE_RESULT=%ERRORLEVEL%

if %COMPILE_RESULT% NEQ 0 (
    echo.
    echo COMPILATION FAILED with error code %COMPILE_RESULT%
    echo.
    echo Attempting to compile all Java files together...
    echo.
    
    REM Try compiling all Java files
    "%JAVA_HOME%\bin\javac" -cp "%CLASSPATH%" -d "%BUILD_DIR%" "%SRC_DIR%\config\*.java" "%SRC_DIR%\dishcovery\*.java" 2>&1
    
    if %ERRORLEVEL% NEQ 0 (
        echo.
        echo FULL COMPILATION ALSO FAILED
        exit /b 1
    ) else (
        echo.
        echo FULL COMPILATION SUCCESSFUL
    )
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
