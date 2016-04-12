import java.awt.Color;

public class InvertFilter extends Filter
{
    /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public InvertFilter(String name)
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
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();
                
                int ir = 255 - r;
                int ig = 255 - g;
                int ib = 255 - b;
                
                Color newColor = new Color(ir, ig, ib);
                
                image.setPixel(x, y, newColor);
            }
        }
    }
}
