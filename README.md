# MultipleScreen
Example of how to use dp units to support Multiple Screens

**Screen size**

Actual physical size, measured as the screen's diagonal.
For simplicity, Android groups all actual screen sizes into four generalized sizes: small, normal, large, and extra-large.

**Screen density**

The quantity of pixels within a physical area of the screen; usually referred to as dpi (dots per inch). For example, a "low" density screen has fewer pixels within a given physical area, compared to a "normal" or "high" density screen.
For simplicity, Android groups all actual screen densities into six generalized densities: low, medium, high, extra-high, extra-extra-high, and extra-extra-extra-high.

**Orientation**

The orientation of the screen from the user's point of view. This is either landscape or portrait, meaning that the screen's aspect ratio is either wide or tall, respectively. Be aware that not only do different devices operate in different orientations by default, but the orientation can change at runtime when the user rotates the device.
Resolution
The total number of physical pixels on a screen. When adding support for multiple screens, applications do not work directly with resolution; applications should be concerned only with screen size and density, as specified by the generalized size and density groups.

**Density-independent pixel (dp)**

A virtual pixel unit that you should use when defining UI layout, to express layout dimensions or position in a density-independent way.
The density-independent pixel is equivalent to one physical pixel on a 160 dpi screen, which is the baseline density assumed by the system for a "medium" density screen. At runtime, the system transparently handles any scaling of the dp units, as necessary, based on the actual density of the screen in use. The conversion of dp units to screen pixels is simple: px = dp * (dpi / 160). For example, on a 240 dpi screen, 1 dp equals 1.5 physical pixels. You should always use dp units when defining your application's UI, to ensure proper display of your UI on screens with different densities.

How does it work?
-----------------

A pixel (px) is a dot. A dot is not a measurement because it depense what the resolution of the device is. DPI counts the number of dots per inch (dpi) from a physical distance of the screen. 

So you could say the higher the DPI the higher the resolution is ! This is very important for images because they rely on the DPI values. 

A low res image will be streched out on a low res screen. This is because the DPI of the screen is much lower, so the number of pixels in one inch is so low that the image may seem to be blurry. 

A set of six generalized densities:
* ldpi (low) ~120dpi
* mdpi (medium) ~160dpi
* hdpi (high) ~240dpi
* xhdpi (extra-high) ~320dpi
* xxhdpi (extra-extra-high) ~480dpi
* xxxhdpi (extra-extra-extra-high) ~640dpi

You can add an image in the following directories. Android will get the image with the right resolution from the directory with the right denisity. A screen with 150dpi will get his image out of drawable-mdpi. When the directory doesn't exist, Android will use the default directory. (drawable)

DP is used as a measurement for all views in Android. A dp isnt the same as a pixel. To calculate a pixel from one dp at a certain screen, you can do the following: px = screens dpi / 160. 

So how can you know when you are on a Tablet or on a Phone? The main difference would be the size of the screen. The resolution can be the same. Read the following the learn more: http://developer.android.com/guide/practices/screens_support.html#DeclaringTabletLayouts

**Calculations** 

600 x 1024 resolution from a 7 inch device. 
7 inch diagonal is 3.54 inch / 6.04 inch.

600px / 3.54 inch = 169 dpi 

I took the amount of pixels of the axis and devided by the amount of inches of the axis. 
This results in the amount of pixels per inch. This is also called DPI. (169 DPI * 3.54 inches = 600 pixels)

169 dpi / 160 dpi (baseline) = 1,06 px for one dp. 

We know how many pixels the axis has. (600) and we know how much a pixel is for one dp. (1,06)

So 600 / 1,06 = 566dp 

**Configuration examples**

To help you target some of your designs for different types of devices, here are some numbers for typical screen widths:

* 320dp: a typical phone screen (240x320 ldpi, 320x480 mdpi, 480x800 hdpi, etc).
* 480dp: a tweener tablet like the Streak (480x800 mdpi).
* 600dp: a 7” tablet (600x1024 mdpi).
* 720dp: a 10” tablet (720x1280 mdpi, 800x1280 mdpi, etc).

Using the size qualifiers, your application can switch between your different layout resources for handsets and tablets using any number you want for width and/or height. For example, if 600dp is the smallest available width supported by your tablet layout, you can provide these two sets of layouts:

res/layout/main_activity.xml           # For handsets
res/layout-sw600dp/main_activity.xml   # For tablets
In this case, the smallest width of the available screen space must be 600dp in order for the tablet layout to be applied.

For other cases in which you want to further customize your UI to differentiate between sizes such as 7” and 10” tablets, you can define additional smallest width layouts:

res/layout/main_activity.xml           # For handsets (smaller than 600dp available width)
res/layout-sw600dp/main_activity.xml   # For 7” tablets (600dp wide and bigger)
res/layout-sw720dp/main_activity.xml   # For 10” tablets (720dp wide and bigger)
Notice that the previous two sets of example resources use the "smallest width" qualifier, sw<N>dp, which specifies the smallest of the screen's two sides, regardless of the device's current orientation. Thus, using sw<N>dp is a simple way to specify the overall screen size available for your layout by ignoring the screen's orientation.

However, in some cases, what might be important for your layout is exactly how much width or height is currently available. For example, if you have a two-pane layout with two fragments side by side, you might want to use it whenever the screen provides at least 600dp of width, whether the device is in landscape or portrait orientation. In this case, your resources might look like this:

res/layout/main_activity.xml         # For handsets (smaller than 600dp available width)
res/layout-w600dp/main_activity.xml  # Multi-pane (any screen with 600dp available width or more)

If the available height is a concern for you, then you can do the same using the h<N>dp qualifier. Or, even combine the w<N>dp and h<N>dp qualifiers if you need to be really specific.

So:
* res/layout-sw720dp/main_activity.xml - Everything that has 720dp width and above
* res/layout-w600dp/main_activity.xml  - Everything that has at least 600dp in width
* res/layout-h600dp/main_activity.xml  - Everything that has at least 600dp in height

Notice that the second set is using the "available width" qualifier, w<N>dp. This way, one device may actually use both layouts, depending on the orientation of the screen (if the available width is at least 600dp in one orientation and less than 600dp in the other orientation).



