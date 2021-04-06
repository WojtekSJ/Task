call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openBrowser
echo.
echo runcrud.bat has errors -breaking work
goto fail

:openBrowser
start "" http://localhost:8080/crud/v1/task/getTasks

:fail
echo.
echo There were errors

:end
echo.
echo Job done!
