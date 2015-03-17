03a-JEA-Kwetter-REST-en-CDI
---------------------------
###Requirements
This project has been created, built and tested in IntelliJ IDEA 14.0.3.
The SDK used is JDK 1.8.0_25.
Glassfish 4.1.0 has been used as server.

###Installation Instructions

**Step 1, Importing:**
Open IDEA (or your own IDE) and choose *Import Project*, choose the pom.xml file.
The next screen has the option *Import Maven projects automatically*, check it.
Also, check the following two: *Automatically download: [X] Sources [X] Documentation* 
The last two checks are not required but will make debugging easier. Click next, IDEA will find the Maven Project hopefully. Select it, click next. As SDK, select or add JDK 1.8. Click next, choose your project name (or leave default) and a location (or leave default) and press next again. The project is now imported.

 **Step 2, Configuring Framework:**
If you did step 1 correctly, IDEA will kindly give you the following note in the Event Log:
*Frameworks detected: Web framework is detected in the project Configure*
Click *Configure*, make sure web.xml is checked and press OK.

If you do not see the note in the Event Log, open up the project structure (*CTRL + SHIFT + ALT + S* or *File, Project Structure*). Go to *Facets*, press the green *"+"* symbol, choose *Web* and select the module (there should be only one). The web.xml file should have been picked up automatically. Press Apply and OK.

**Step 3, Creating Artifact:**
Open up the project structure (*CTRL + SHIFT + ALT + S* or *File, Project Structure*). Go to *Modules* and select the *Web* module which is a child module. At the very bottom an exclamation mark should show with the message "'Web' Facet resources are not included in an artifact" and a button with the text "Create Artifact", click it. Press Apply and OK.

**Step 4, Run Configuration:**
Go to *Run* and click *Edit Configurations*. Press the green *"+"* symbol, choose *Glassfish Server* and click *Local*. Set *Server Domain* to your domain (i.e. C:\glassfish4\glassfish\domains\domain1). Make sure the username and password are correct. Now go to the tab "Deployment", press the green *"+"* symbol and click Artifact. The artifact should be automatically added. Press Apply and OK.
