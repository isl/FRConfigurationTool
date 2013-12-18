-------------------------------------------------
          Set Sesame Repositories Path
-------------------------------------------------


CURRENT TEXT VARIABLES AND ABBREVIATIONS
----------------------------------------

<APP>						Application name
<HOME_DIR>					The base directory of the application



To set the path for Sesame repositories:
----------------------------------------

1. Open <APP>-INIT.bat with text editor. (Located at: <HOME_DIR>\bin\<APP>-INIT.bat file.)

2. Locate at the: SET JAVA_OPTS=%JAVA_OPTS% -Dinfo.aduna.platform.appdata.basedir=
   and put the new file path.
   
   For example:
   
   SET JAVA_OPTS=%JAVA_OPTS% -Dinfo.aduna.platform.appdata.basedir=..\sesame_data	
