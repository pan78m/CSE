@echo off
rem START or STOP Services
rem ----------------------------------
rem Check if argument is STOP or START

if not ""%1"" == ""START"" goto stop


"C:\Users\Admin\Desktop\CSE\Server\mysql\bin\mysqld" --defaults-file="C:\Users\Admin\Desktop\CSE\Server\mysql\bin\my.ini" --standalone
if errorlevel 1 goto error
goto finish

:stop
cmd.exe /C start "" /MIN call "C:\Users\Admin\Desktop\CSE\Server\killprocess.bat" "mysqld.exe"

if not exist "C:\Users\Admin\Desktop\CSE\Server\mysql\data\%computername%.pid" goto finish
echo Delete %computername%.pid ...
del "C:\Users\Admin\Desktop\CSE\Server\mysql\data\%computername%.pid"
goto finish


:error
echo MySQL could not be started

:finish
exit
