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
package HotReloadLibrary.Backend;

// @Todo: consider renaming this file and moving it to the frontend portion of the library...
import HotReloadLibrary.HotReloadFrontend;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public final class HotReloadBackend {
    ///-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> BootstrapThisWindow
    //>>
    //>>    Bootstraps the calling window to the hotreload library so that we
    //>>    can hotreload the widdow's CSS.  This MUST be called by the calling window.
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void BootstrapThisWindow( Node window, String cssPath ) {
        try {
            if( !alreadyBootstrapped ) {
                loader = new FXMLLoader( HotReloadFrontend.class.getResource( "HotReloadFrontend.fxml" ) );
                Parent parent = (Parent)loader.load();

                Stage stage = new Stage();
                stage.initModality(  Modality.NONE );
                stage.initStyle( StageStyle.UTILITY );
                stage.setTitle( "JavaFX CSS Hot Reloading Library By Nathan Young" );
                stage.setResizable( false );

                Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

                //set Stage boundaries to the lower right corner of the visible bounds of the main screen
                stage.setX( primaryScreenBounds.getMinX() + ( primaryScreenBounds.getWidth() - 400 ) );
                stage.setY( primaryScreenBounds.getMinY() + ( primaryScreenBounds.getHeight() - 300 ) ) ;

                Scene stageScene = new Scene( parent );

                HotReloadFrontend.window = window;
                HotReloadFrontend.cssPath = cssPath;
                
                alreadyBootstrapped = true;

                stage.setScene( stageScene );
                stage.show();
            } else {
                HotReloadFrontend.window = window;
                HotReloadFrontend.cssPath = cssPath;
            }
        } catch( Exception except ) {
            HotReloadException.Raise( except );
        }
    }
    
    private static FXMLLoader loader;
    private static boolean alreadyBootstrapped = false;
}
