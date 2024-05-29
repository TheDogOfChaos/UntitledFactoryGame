package io.thedogofchaos.fmp.utils;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;

public class TextureUtils{
    public static TextureRegionDrawable resizeDrawable(TextureRegion region, int width, int height) {
        // Create a Pixmap from the region
        Texture texture = region.getTexture();

        if (!texture.getTextureData().isPrepared()) {
            texture.getTextureData().prepare();
        }
        Pixmap originalPixmap = texture.getTextureData().consumePixmap();

        // Create a Pixmap of the desired size
        Pixmap resizedPixmap = new Pixmap(width, height, originalPixmap.getFormat());

        // Draw the original Pixmap onto the resized Pixmap
        resizedPixmap.drawPixmap(originalPixmap,
        region.getRegionX(), region.getRegionY(), region.getRegionWidth(), region.getRegionHeight(),
        0, 0, width, height);

        // Create a new Texture from the resized Pixmap
        TextureRegion resizedRegion = new TextureRegion(new Texture(resizedPixmap));

        // Dispose of Pixmaps to free up memory
        originalPixmap.dispose();
        resizedPixmap.dispose();

        // Return a new TextureRegionDrawable
        return new TextureRegionDrawable(resizedRegion);
    }
}
