Because of the nature of JavaFX applications, and this library’s function, the library is laid out a little differently than most Java libraries.  
This project will compile into a demo JavaFX executable that demonstrates the library in action.

There are two Java packages, “HotReloadLibrary,” and “DemoFiles.”  All of the files in “HotReloadLibrary” are the actual library and can be copied into your program.  
Any files that reside in “DemoFiles” relate to the demo JavaFX program and are not needed (however, they do show how to implement the library past the supplied instructions).


Video of library in action:

	https://www.youtube.com/watch?v=8aTuv_lADts


Quick Library Implementation Guide
--------------------------------------------
Due to how this library works, you will need to use library’s windowing system.  This system can be combined with an already established project, but any FXML window that you want to 
hot reload CSS for will need to be managed by this windowing system.

To use this library:

	import HotReloadLibrary.Backend.*;

And then create the window(s) you want to allow hot reloading for via the following:

	HotReloadWindowParams <instanceName> = new HotReloadWindowParams();
	<instanceName>.name = “SomeWindowName”;
	<instanceName>.title = “SomeWindowTitle”;
	<instanceName>.allowHotReloading = true;
	<instanceName>.cssPath = “some/path/to/css/file.css”;
	<instanceName>.fxmlFile = “path/to/fxml.file”;

	HotReloadWindowSystem.CreateAndSHow( <instanceName>, this.getClass() );
	
	
As a quick sidenote,
	"HotReloadWindowParams" supplies two flags for setting the width and height of the created window.
	If these are not specified, the window will resort to the default max window width and height defined
	in the FXML file.

For a working example, see “HotReloadLibraryDemo_EntryPoint.java” lines 26 and 49 – 57.
