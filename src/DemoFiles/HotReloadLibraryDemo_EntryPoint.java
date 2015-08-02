//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//>> The MIT License (MIT)
//>>
//>> Copyright (c) 2015 Nathan Young.
//>>
//>> Permission is hereby granted, free of charge, to any person obtaining a copy
//>> of this software and associated documentation files (the "Software"), to deal
//>> in the Software without restriction, including without limitation the rights
//>> to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//>> copies of the Software, and to permit persons to whom the Software is
//>> furnished to do so, subject to the following conditions:
//>>
//>> The above copyright notice and this permission notice shall be included in
//>> all copies or substantial portions of the Software.
//>> 
//>> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//>> IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//>> FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//>> AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//>> LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//>> OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//>> THE SOFTWARE.
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
package DemoFiles;

import HotReloadLibrary.Backend.*;
import HotReloadLibrary.HotReloadFrontend;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Nathan
 */
public class HotReloadLibraryDemo_EntryPoint extends Application {
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> start
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @Override
    public void start( Stage stage ) throws Exception {
        HotReloadWindowParams demoWindow = new HotReloadWindowParams();
        demoWindow.name = "Window_Demo";
        demoWindow.title = "HotReloadLibrary: Main Demo Window";
        demoWindow.allowHotReloading = true;
        demoWindow.cssPath = "src/DemoFiles/DemoResources/DemoWindow.css";
        demoWindow.fxmlFile = "HotReloadLibraryDemo_MainWindow.fxml";
        
        HotReloadWindowSystem.CreateAndShow( demoWindow, this.getClass() );
    }
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> stop
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @Override
    public void stop() throws Exception {
        super.stop();
        
        EventHook_ApplicationIsClosing();
    }
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> EventHook_ApplicationIsClosing
    //>>
    //>>    This SHOULD be called from an overriden version of Application.stop
    //>>    so that we can gracefully release everything... though, if the application
    //>>    exits, the VM SHOULD release everything that has been allocated.
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void EventHook_ApplicationIsClosing() {
        // Release any active windows that are currently on the window system stack.
        HotReloadWindowSystem.activeWindows.clear();
        
        // Close the created hot reload window create by the hot reload library.
        Stage stageHandle = (Stage)HotReloadFrontend.window.getScene().getWindow();
        stageHandle.close();
    }
    
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> main
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void main( String[] args ) {
        launch(args);
    }
}
