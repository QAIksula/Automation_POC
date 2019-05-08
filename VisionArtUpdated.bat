set projectLocation=C:\Users\user\Downloads\jar_1\jars\VisionArt
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml