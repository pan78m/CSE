@echo off
rem START or STOP Services
rem ----------------------------------
rem Check if argument is STOP or START

if not ""%1"" == ""START"" goto stop

if exist C:\Users\Admin\Desktop\CSE\Server\hypersonic\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\server\hsql-sample-database\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\ingres\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\ingres\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\mysql\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\mysql\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\postgresql\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\postgresql\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\apache\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\apache\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\openoffice\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\openoffice\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\apache-tomcat\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\apache-tomcat\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\resin\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\resin\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\jetty\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\jetty\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\subversion\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\subversion\scripts\ctl.bat START)
rem RUBY_APPLICATION_START
if exist C:\Users\Admin\Desktop\CSE\Server\lucene\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\lucene\scripts\ctl.bat START)
if exist C:\Users\Admin\Desktop\CSE\Server\third_application\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\third_application\scripts\ctl.bat START)
goto end

:stop
echo "Stopping services ..."
if exist C:\Users\Admin\Desktop\CSE\Server\third_application\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\third_application\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\lucene\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\lucene\scripts\ctl.bat STOP)
rem RUBY_APPLICATION_STOP
if exist C:\Users\Admin\Desktop\CSE\Server\subversion\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\subversion\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\jetty\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\jetty\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\hypersonic\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\server\hsql-sample-database\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\resin\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\resin\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\apache-tomcat\scripts\ctl.bat (start /MIN /B /WAIT C:\Users\Admin\Desktop\CSE\Server\apache-tomcat\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\openoffice\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\openoffice\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\apache\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\apache\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\ingres\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\ingres\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\mysql\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\mysql\scripts\ctl.bat STOP)
if exist C:\Users\Admin\Desktop\CSE\Server\postgresql\scripts\ctl.bat (start /MIN /B C:\Users\Admin\Desktop\CSE\Server\postgresql\scripts\ctl.bat STOP)

:end

