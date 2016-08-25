package game.tilemap;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class MirrorImage {
	public static BufferedImage mirrorHorizontal(BufferedImage image) {
		BufferedImage mirroredImage = deepCopy(image);
		
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-mirroredImage.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		mirroredImage = op.filter(image, null);
		
		return mirroredImage;
	}
	
	public static BufferedImage deepCopy(BufferedImage image) {
		ColorModel cm = image.getColorModel();
	    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
	    WritableRaster raster = image.copyData(image.getRaster().createCompatibleWritableRaster());
	    
	    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
}
