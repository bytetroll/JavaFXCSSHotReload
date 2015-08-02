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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HotReloadLibraryDemo_MainWindow implements Initializable {
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> initialize
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @Override
    public void initialize( URL url, ResourceBundle rb ) {
        
    }
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> EventCallback_ButtonDemoClicked
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @FXML
    private void EventCallback_ButtonDemoClicked( ActionEvent evt ) {
        HotReloadWindowParams newDemoWindow = new HotReloadWindowParams();
        newDemoWindow.name = "Window_Demo_New";
        newDemoWindow.title = "HotReloadLibrary: New Demo Window";
        newDemoWindow.allowHotReloading = true;
        newDemoWindow.cssPath = "src/DemoFiles/DemoResources/NewDemoWindow.css";
        newDemoWindow.fxmlFile = "HotReloadLibraryDemo_NewWindow.fxml";
        
        HotReloadWindowSystem.Close( "Window_Demo" );
        HotReloadWindowSystem.CreateAndShow( newDemoWindow, this.getClass() );
    }
    
    @FXML 
    private Button buttonDemo;
}
