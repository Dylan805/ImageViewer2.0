import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class EdgeDetectionFilter extends Filter
{
    private int height;
    private int width;
    private OFImage copy;
    
    /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public EdgeDetectionFilter(String name)
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
        copy = new OFImage(image);
        height = image.getHeight();
        width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                image.setPixel(x, y, edgeColor(x,y));
            }
        }
    }
    
    private Color edgeColor(int xcord, int ycord)
    {
        
        List<Color> pixels = new ArrayList<Color>(9);
        
        for (int y = ycord - 1; y <= ycord + 1; y++)
        {
            for (int x = xcord - 1; x <= xcord + 1; x++)
            {
                if (x >= 0 && x < width && y >= 0 && y < height)
                {
                    pixels.add(copy.getPixel(x,y));
                }
            }
        }
        
        return new Color (redDiff(pixels), greenDiff(pixels), blueDiff(pixels));
    }
    
    private int redDiff(List<Color> list)
    {
        int max = 0;
        int min = 255;
        
        for (Color color : list)
        {
            int value = color.getGreen();
            if (value > max)
            {
                max = value;
            }
            if (value < min)
            {
                min = value;
            }
        }
        int diff = max - min;
        if (diff < 0)
        {
           diff = 0;
        }
        return diff;

    }
    private int greenDiff(List<Color> list)
    {
        int max = 0;
        int min = 255;
        
        for (Color color : list)
        {
            int value = color.getGreen();
            if (value > max)
            {
                max = value;
            }
            if (value < min)
            {
                min = value;
            }
        }
        int diff = max - min;
        if (diff < 0)
        {
           diff = 0;
        }
        return diff;

    }
    private int blueDiff(List<Color> list)
    {
        int max = 0;
        int min = 255;
        
        for (Color color : list)
        {
            int value = color.getBlue();
            if (value > max)
            {
                max = value;
            }
            if (value < min)
            {
                min = value;
            }
        }
        int diff = max - min;
        if (diff < 0)
        {
           diff = 0;
        }
        return diff;

    }
}
