
echo 123456
del print.jar

jar -cvf print.jar *.class

jarsigner -keystore applet.store print.jar applet


