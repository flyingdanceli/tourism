<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<html>
<head>
<title>
打印
</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body BGCOLOR="#ffffff" LINK="#000099">
<!--"CONVERTED_APPLET"-->
<!-- HTML CONVERTER -->

<applet  id="myapply"   CODE = "PrinterApplet.class" CODEBASE = "${appPath }/applets" ARCHIVE = "print.jar,jasperreports-applet-5.1.0.jar,commons-logging-1.1.1.jar,commons-collections-2.1.1.jar" WIDTH = "300" HEIGHT = "40">
    <PARAM NAME = CODE VALUE = "PrinterApplet.class" >
	<PARAM NAME = CODEBASE VALUE = "${appPath }/applets" >
	<PARAM NAME = ARCHIVE VALUE = "print.jar,jasperreports-applet-5.1.0.jar,commons-logging-1.1.1.jar,commons-collections-2.1.1.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.2">
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME = "REPORT_URL" VALUE ="${reportUrl}">
    <PARAM NAME = "AUTO_PRINT" VALUE ="${autoPrint }">
    <PARAM NAME = "AUTO_VIEW" VALUE ="${autoView }">
</applet>

<!--
<APPLET  id="myapply"  CODE = "PrinterApplet.class" CODEBASE = "applets" ARCHIVE = "jasperreports-applet-5.1.0.jar,commons-logging-1.1.1.jar,commons-collections-2.1.1.jar" WIDTH = "300" HEIGHT = "40">
<PARAM NAME = "REPORT_URL" VALUE ="../servlets/jasperprint">

</APPLET>
-->
<!--"END_CONVERTED_APPLET"-->
</body>
</html>
