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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public final class HotReloadWindowSystem {
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> CreateAndShow
    //>>
    //>>    Creates and new window, adds it to the active windows list, and bootstraps
    //>>    the window for hot reload.
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void CreateAndShow( HotReloadWindowParams wp, Class callingClass ) {
        try {
            FXMLLoader loader = new FXMLLoader( callingClass.getResource( wp.fxmlFile ) );
            Parent parent = (Parent)loader.load();
            
            Stage stage = new Stage();
            stage.initModality( Modality.NONE );
            stage.initStyle( StageStyle.UTILITY );
            stage.setResizable( false );
            stage.setTitle( wp.title );
            stage.setWidth( wp.width );
            stage.setHeight( wp.height );
            
            if( wp.allowHotReloading && wp.cssPath != null /*&& geClientConfig.ENABLE_EXPERIMENTAL_FEATURES*/ ) {
                HotReloadBackend.BootstrapThisWindow( parent, wp.cssPath );
            }
            
            Scene scene = new Scene( parent );
            
            if( wp.cssPath != null ) {
                scene.getStylesheets().add( HotReloadFilesystem.Load( wp.cssPath ) );
            }
            stage.setScene( scene );
            
            wp.windowStage = stage;
            wp.isVisible = true;
            
            activeWindows.add( wp );
            
            wp.windowScene = scene;
            wp.windowStage = stage;
            
            stage.show();      
        } catch( IOException except ) {
            HotReloadException.Raise( except );
        }
    }
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> Close
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void Close( String windowName ) {
        for( HotReloadWindowParams param : activeWindows ) {
            if( param.name.equals( windowName ) ) {
                param.windowStage.close();       
                activeWindows.remove( param );
                break;
            }
        }
    }
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> Find
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static HotReloadWindowParams Find( String windowName ) {
        for( HotReloadWindowParams param : activeWindows ) {
            if( param.name.equals( windowName ) ) {
                return( param );
            }
        }
       
        return( null );
    }
   
    public static List< HotReloadWindowParams > activeWindows = new ArrayList<>();
}
