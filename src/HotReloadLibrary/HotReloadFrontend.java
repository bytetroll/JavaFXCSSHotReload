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
package HotReloadLibrary;

import HotReloadLibrary.Backend.HotReloadFilesystem;
import HotReloadLibrary.Backend.HotReloadPainter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.util.Duration;

public class HotReloadFrontend implements Initializable {
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> initialize
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @Override
    public void initialize( URL url, ResourceBundle rb ) {
            final Glow glow = new Glow();
            glow.setLevel( 0.0f );
           
            Background bgGreen = HotReloadPainter.BackgroundFromColor( HotReloadPainter.ColorGreen );
            Background bgBlue = HotReloadPainter.BackgroundFromColor( HotReloadPainter.ColorBlue );
            
            buttonReload.setBackground( bgGreen );
            thisWindow.setBackground( bgBlue );
            
            buttonReload.setEffect( glow );
            thisWindow.setEffect( glow );

            final Timeline timeline = new Timeline();
            timeline.setCycleCount( Timeline.INDEFINITE );
            timeline.setAutoReverse( true );
            final KeyValue kv = new KeyValue( glow.levelProperty(), 0.3f );
            final KeyFrame kf = new KeyFrame(Duration.millis( 700 ), kv );
            timeline.getKeyFrames().add( kf );
            timeline.play(); 
    }
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> EventCallback_ButtonReloadPressed
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @FXML
    private void EventCallback_ButtonReloadPressed( ActionEvent evt ) {
        if( window != null ) {
            Parent p = (Parent)window;
            p.getStylesheets().clear();
            p.getStylesheets().add( HotReloadFilesystem.Load( cssPath ) ) ;
        }
    }
    
    public static Node window;
    public static String cssPath;
    
    @FXML Button buttonReload;
    @FXML AnchorPane thisWindow;
}
