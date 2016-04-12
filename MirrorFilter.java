import java.awt.Color;

public class MirrorFilter extends Filter
{
    /**
     * Constructor for objects of class MirrorFilter.
     * @param name The name of the filter.
     */
    public MirrorFilter(String name)
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
            for(int x = 0; x < width/2; x++) {
                Color pixel1 = image.getPixel(x, y);
                Color pixel2 = image.getPixel(width - x - 1, y);
                
                image.setPixel(width - x - 1, y, pixel1);
                image.setPixel(x, y, pixel2);
            }
        }
    }
}
