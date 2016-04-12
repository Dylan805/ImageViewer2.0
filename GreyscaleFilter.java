import java.awt.Color;

public class GreyscaleFilter extends Filter
{
    /**
     * Constructor for objects of class GreyscaleFilter.
     * @param name The name of the filter.
     */
    public GreyscaleFilter(String name)
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
                Color pixel = image.getPixel(x, y);
                int average = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                Color grey = new Color(average, average, average);
                image.setPixel(x, y, grey);
                
            }
        }
    }
}
