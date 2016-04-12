import java.awt.Color;

public class SmoothFilter extends Filter
{
    /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public SmoothFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        OFImage copy = new OFImage(image);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color mm = copy.getPixel(x, y);
                //Getting the current pixel
                
                int red = 0;
                int blue = 0;
                int green = 0;
                
                int divider = 9;
                //Initializing the numer that will be used to get the average.
                
                if (x == 0 && y != 0 && y != height - 1)
                {
                    Color um = copy.getPixel(x, y - 1);
                    Color ur = copy.getPixel(x + 1, y - 1);
                    Color mr = copy.getPixel(x + 1, y);
                    Color bm = copy.getPixel(x, y + 1);
                    Color br = copy.getPixel(x + 1, y + 1);
                    Color ul = null;
                    Color ml = null;
                    Color bl = null;
                    red = red + um.getRed() + ur.getRed() + mr.getRed() + bm.getRed() + br.getRed() + mm.getRed();
                    green = green + um.getGreen() + ur.getGreen() + mr.getGreen() + bm.getGreen() + br.getGreen() + mm.getGreen();
                    blue = blue + um.getBlue() + ur.getBlue() + mr.getBlue() + bm.getBlue() + br.getBlue() + mm.getBlue();
                    divider = divider - 3;
                }
                //Check if pixel is on the left side.
                
                else if (y == 0 && x != 0 && x != width - 1)
                {
                    Color ml = copy.getPixel(x - 1, y);
                    Color mr = copy.getPixel(x + 1, y);
                    Color bl = copy.getPixel(x - 1, y + 1);
                    Color bm = copy.getPixel(x, y + 1);
                    Color br = copy.getPixel(x + 1, y + 1);
                    Color ul = null;
                    Color um = null;
                    Color ur = null;
                    red = red + ml.getRed() + bl.getRed() + mr.getRed() + bm.getRed() + br.getRed() + mm.getRed();
                    green = green + ml.getGreen() + bl.getGreen() + mr.getGreen() + bm.getGreen() + br.getGreen() + mm.getGreen();
                    blue = blue + ml.getBlue() + bl.getBlue() + mr.getBlue() + bm.getBlue() + br.getBlue() + mm.getBlue();
                    divider = divider - 3;
                }
                //Check if pixel is on the top side.
                
                else if (x == 0 && y == 0)
                {
                    Color mr = copy.getPixel(x + 1, y);
                    Color bm = copy.getPixel(x, y + 1);
                    Color br = copy.getPixel(x + 1, y + 1);
                    Color ul = null;
                    Color ml = null;
                    Color bl = null;
                    Color um = null;
                    Color ur = null;
                    red = red + mr.getRed() + bm.getRed() + br.getRed() + mm.getRed();
                    green = green + mr.getGreen() + bm.getGreen() + br.getGreen() + mm.getGreen();
                    blue = blue + mr.getBlue() + bm.getBlue() + br.getBlue() + mm.getBlue();
                    divider = divider - 5;
                }
                //Check if pixel is the left corner.
                
                else if (x == width - 1 && y != height - 1 && y != 0)
                {
                    Color ul = copy.getPixel(x - 1, y - 1);
                    Color um = copy.getPixel(x, y - 1);
                    Color ml = copy.getPixel(x - 1, y);
                    Color bl = copy.getPixel(x - 1, y + 1);
                    Color bm = copy.getPixel(x, y + 1);
                    Color ur = null;
                    Color mr = null;
                    Color br = null;
                    red = red + um.getRed() + ul.getRed() + ml.getRed() + bm.getRed() + bl.getRed() + mm.getRed();
                    green = green + um.getGreen() + ul.getGreen() + ml.getGreen() + bm.getGreen() + bl.getGreen() + mm.getGreen();
                    blue = blue + um.getBlue() + ul.getBlue() + ml.getBlue() + bm.getBlue() + bl.getBlue() + mm.getBlue();
                    divider = divider - 3;
                }
                //Check if pixel is on the right side.
                
                else if (y == height - 1 && x != width - 1 && x != 0)
                {
                    Color ul = copy.getPixel(x - 1, y - 1);
                    Color um = copy.getPixel(x, y - 1);
                    Color ur = copy.getPixel(x + 1, y - 1);
                    Color ml = copy.getPixel(x - 1, y);
                    Color mr = copy.getPixel(x + 1, y);
                    Color bl = null;
                    Color bm = null;
                    Color br = null;
                    red = red + um.getRed() + ur.getRed() + mr.getRed() + ml.getRed() + ul.getRed() + mm.getRed();
                    green = green + um.getGreen() + ur.getGreen() + mr.getGreen() + ml.getGreen() + ul.getGreen() + mm.getGreen();
                    blue = blue + um.getBlue() + ur.getBlue() + mr.getBlue() + ml.getBlue() + ul.getBlue() + mm.getBlue();
                    divider = divider - 3;
                }
                //Check if pixel is on the bottom side.
                
                else if (y == height - 1 && x == width - 1)
                {
                    Color ul = copy.getPixel(x - 1, y - 1);
                    Color um = copy.getPixel(x, y - 1);
                    Color ml = copy.getPixel(x - 1, y);
                    Color bl = null;
                    Color bm = null;
                    Color br = null;
                    Color ur = null;
                    Color mr = null;
                    red = red + um.getRed() + ml.getRed() + ul.getRed() + mm.getRed();
                    green = green + um.getGreen() + ml.getGreen() + ul.getGreen() + mm.getGreen();
                    blue = blue + um.getBlue() + ml.getBlue() + ul.getBlue() + mm.getBlue();;
                    divider = divider - 5;
                }
                //Check if pixel is the bottom right corner.
                
                else if (y == 0 && x == width - 1)
                {
                    Color ml = copy.getPixel(x - 1, y);
                    Color bl = copy.getPixel(x - 1, y + 1);
                    Color bm = copy.getPixel(x, y + 1);
                    Color ul = null;
                    Color um = null;
                    Color ur = null;
                    Color mr = null;
                    Color br = null;
                    red = red + bm.getRed() + ml.getRed() + bl.getRed() + mm.getRed();
                    green = green + ml.getGreen() + bl.getGreen() + bm.getGreen() + mm.getGreen();
                    blue = blue + ml.getBlue() + bl.getBlue() + bm.getBlue() + mm.getBlue();;
                    divider = divider - 5;
                }
                //Check if pixel is the top right corner.
                
                else if (x == 0 && y == height - 1)
                {
                    Color um = copy.getPixel(x, y - 1);
                    Color ur = copy.getPixel(x + 1, y - 1);
                    Color mr = copy.getPixel(x + 1, y);
                    Color ul = null;
                    Color ml = null;
                    Color bl = null;
                    Color bm = null;
                    Color br = null;
                    red = red + um.getRed() + ur.getRed() + mr.getRed() + mm.getRed();
                    green = green + um.getGreen() + ur.getGreen() + mr.getGreen() + mm.getGreen();
                    blue = blue + um.getBlue() + ur.getBlue() + mr.getBlue() + mm.getBlue();
                    divider = divider - 5;
                }
                //Check if the pixel is the bottom left corner.
                
                else
                {
                    Color ul = copy.getPixel(x - 1, y - 1);
                    Color um = copy.getPixel(x, y - 1);
                    Color ur = copy.getPixel(x + 1, y - 1);
                    Color ml = copy.getPixel(x - 1, y);
                    Color mr = copy.getPixel(x + 1, y);
                    Color bl = copy.getPixel(x - 1, y + 1);
                    Color bm = copy.getPixel(x, y + 1);
                    Color br = copy.getPixel(x + 1, y + 1);
                    red = red + um.getRed() + ur.getRed() + mr.getRed() + bm.getRed() + br.getRed() + mm.getRed() + bl.getRed() + ml.getRed() + ul.getRed();
                    green = green + um.getGreen() + ur.getGreen() + mr.getGreen() + bm.getGreen() + br.getGreen() + mm.getGreen() + bl.getGreen() + ml.getGreen() + ul.getGreen();
                    blue = blue + um.getBlue() + ur.getBlue() + mr.getBlue() + bm.getBlue() + br.getBlue() + mm.getBlue() + bl.getBlue() + ml.getBlue() + ul.getBlue();
                }
                //If the pixel is somewhere not along the edges.
                
                red = red / divider;
                green = green / divider;
                blue = blue / divider;
                //Get color components for the new color
                
                Color newc = new Color(red, green, blue);
                //Create the new color
                
                image.setPixel(x, y, newc);
                //Setting color
            }
        }
    }
}
