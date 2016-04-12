import java.awt.Color;

public class SolarizeFilter extends Filter
{
    /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public SolarizeFilter(String name)
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
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x,y);
                
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
                //Getting original componants
                
                if (red < 128)
                {
                    red = 255 - red;
                }
                if (green < 128)
                {
                    green = 255 - green;
                }
                if (blue < 128)
                {
                    blue = 255 - blue;
                }
                //Doing solarize algorithm
                
                Color scolor = new Color(red, green, blue);
                //Making new color
                
                image.setPixel(x, y, scolor);
                //Setting pixel
            }
        }
    }
}
