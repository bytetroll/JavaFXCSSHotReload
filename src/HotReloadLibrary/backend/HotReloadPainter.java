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

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public final class HotReloadPainter {
    public static final String ColorRed = "#fd4e52";
    public static final String ColorWhite = "#ededed";
    public static final String ColorBlue = "#469ccb";
    public static final String ColorGreen = "#49d642";
    public static final String ColorDarkGrey = "#535353";
    public static final String ColorLightGrey = "#d9d9d9";
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //>> BackgroundFromColor
    //>>
    //>>    Creates a background from a color code.
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static Background BackgroundFromColor( String color ) {
        BackgroundFill fill = new BackgroundFill( Color.web( color ), new CornerRadii( 1 ), null );
        return( new Background( fill ) );
    }
}
